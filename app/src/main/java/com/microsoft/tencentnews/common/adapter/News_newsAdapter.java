package com.microsoft.tencentnews.common.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.bean.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 16-7-6.
 */
public class News_newsAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<NewsBean.NewsContent> newsContentList;
    private final LayoutInflater inflater;

    int maxWidth;
    int maxHeight;

    public News_newsAdapter(Context context, List<NewsBean.NewsContent> List){
        this.context = context;
        this.newsContentList = List;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount(){
        return newsContentList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View inflateView = inflater.inflate(R.layout.itemlayout_recycleview_news_news, parent, false);
        MyViewHolder myHolder = new MyViewHolder(inflateView);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        ((MyViewHolder) holder).titleText.setText(newsContentList.get(position).getTitle());
        ((MyViewHolder) holder).comment.setText(newsContentList.get(position).getSource());
        String imgurl = newsContentList.get(position).getThumbnails_qqnews_photo().get(0);
        final Bitmap[] holderbitmap = new Bitmap[1];
        // volley 下载图片包括二次采样输入（maxwidth,maxheight）
        ImageRequest imageRequest = new ImageRequest(imgurl, new Response.Listener<Bitmap>(){
            @Override
            public void onResponse(Bitmap bitmap){
                holderbitmap[0] = bitmap;
            }
        }, maxWidth, maxHeight, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError){
                Log.e("onErrorResponse: ", "image down error ");
               // Toast.makeText(context, "image network error", Toast.LENGTH_SHORT).show();
            }
        });

        ((MyViewHolder) holder).imageView.setImageBitmap(holderbitmap[0]);
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


            Log.e("onBindViewHolder: ",maxWidth+"---"+maxHeight );
        }
    }
}
