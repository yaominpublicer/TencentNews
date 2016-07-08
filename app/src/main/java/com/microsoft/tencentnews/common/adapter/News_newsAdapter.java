package com.microsoft.tencentnews.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.bean.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 16-7-6.
 */
public class News_newsAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<NewsBean.NewsContent> newsContentList;
    private final LayoutInflater inflater;


    private final int TYPE_FOOTVIEW = 0;
    private final int TYPE_ITEMVIEW = 1;
    private final int TYPE_HEADVIEW = 2;



    int maxWidth;
    int maxHeight;
    private final AlphaAnimation alphaAnimation;
    public News_newsAdapter(Context context, List<NewsBean.NewsContent> List){
        this.context = context;
        this.newsContentList = List;
        inflater = LayoutInflater.from(context);
        alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setStartOffset(1000);


    }

    @Override
    public int getItemCount(){
        return newsContentList.size();
    }

    @Override
    public int getItemViewType(int position){

        if(position + 1 == getItemCount()){

            return TYPE_FOOTVIEW;
        }else if(position == 0){
           return TYPE_HEADVIEW ;
        }else {
            return TYPE_ITEMVIEW;
        }



    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        if(TYPE_ITEMVIEW == viewType){

            View inflateView = inflater.inflate(R.layout.itemlayout_recycleview_news_news, parent, false);
            MyViewHolder myHolder = new MyViewHolder(inflateView);
            return myHolder;
        }else if(TYPE_FOOTVIEW == viewType) {

            View footView=inflater.inflate(R.layout.footview_news_news,parent,false);
            return new MyFootViewHolder(footView);
        }else {


            View headView=inflater.inflate(R.layout.headview_news_news,parent,false);

            return new MyHeadViewHolder(headView);


        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position){

        //如果是itemview的话 就绑定 否则什么都不做就显示一下
        if(holder instanceof MyViewHolder ){
            ((MyViewHolder) holder).titleText.setText(newsContentList.get(position).getTitle());
            ((MyViewHolder) holder).comment.setText(newsContentList.get(position).getSource());
            String imgurl = newsContentList.get(position).getThumbnails_qqnews_photo().get(0);
            // volley 下载图片包括二次采样输入（maxwidth,maxheight）
            HttpUtils.volleyLoadImage(context, maxWidth, maxHeight, imgurl, ((MyViewHolder) holder).imageView);
        }else if(holder instanceof MyFootViewHolder){
            ((MyFootViewHolder) holder).view.startAnimation(alphaAnimation);
        }else {
            MyHeadViewHolder myHeadViewHolder = (MyHeadViewHolder) holder;
            HttpUtils.volleyLoadImage(context,myHeadViewHolder.headimageWidth,
                    myHeadViewHolder.headimageHeight,
                    newsContentList.get(0).getThumbnails_qqnews_photo().get(0),
                    myHeadViewHolder.headimage
                    );
        }



    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView titleText;
        TextView comment;

        public MyViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_news_news);
            titleText = (TextView) itemView.findViewById(R.id.title_news_news);
            comment = (TextView) itemView.findViewById(R.id.comment_news_news);
            maxWidth =  imageView.getLayoutParams().width;
            maxHeight = imageView.getLayoutParams().height;


            Log.e("onBindViewHolder: 4",maxWidth+"---"+maxHeight );
        }
    }

    class MyFootViewHolder extends RecyclerView.ViewHolder{

        View view;
        public MyFootViewHolder(View itemView){
            super(itemView);
            this.view = itemView;
        }
    }

    class MyHeadViewHolder extends RecyclerView.ViewHolder{

        ImageView headimage;
          int headimageWidth;
         int headimageHeight;


        public MyHeadViewHolder(View itemView){

            super(itemView);

            headimage= (ImageView) itemView.findViewById(R.id.headview_news_news);



            headimageWidth =headimage.getLayoutParams().width;
            headimageHeight=headimage.getLayoutParams().height;


        }
    }





}
