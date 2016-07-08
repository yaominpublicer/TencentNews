package com.microsoft.tencentnews.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.common.net.HttpUtils;
import com.microsoft.tencentnews.modules.fragment_recommend.bean.NewsBeanRecommend;

import java.util.List;

/**
 * Created by Administrator on 16-7-8.
 */
public class Recommend_Adapter extends RecyclerView.Adapter{

    private  List<NewsBeanRecommend> list;
    private  Context context;
    private int imgWidth;
    private int imgHeight;
    private  LayoutInflater inflater;

    public Recommend_Adapter(Context context, List<NewsBeanRecommend> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);



    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){


        View recommendView = inflater.inflate(R.layout.itemlayout_recommend,parent,false);

        RecommendViewHolder recommendViewHolder = new RecommendViewHolder(recommendView);

        return recommendViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        ((RecommendViewHolder) holder).title_recommend.setText(list.get(position).getTitle());
        ((RecommendViewHolder) holder).comment_recommend.setText(list.get(position).getReason_name());

        String imgurl=list.get(position).getThumbnails_qqnews().get(0);
        HttpUtils.volleyLoadImage(context,imgWidth,imgHeight,imgurl,((RecommendViewHolder) holder).img_recommend);

    }

    @Override
    public int getItemCount(){
        return list.size();
    }


   class RecommendViewHolder extends RecyclerView.ViewHolder{

       ImageView img_recommend;
       TextView title_recommend;
       TextView comment_recommend;


       public RecommendViewHolder(View itemView){
           super(itemView);

           img_recommend = (ImageView) itemView.findViewById(R.id.item_img_recommend);
           title_recommend=((TextView) itemView.findViewById(R.id.item_title_recommend));
           comment_recommend = (TextView) itemView.findViewById(R.id.item_comment_recommend);

            imgWidth = img_recommend.getLayoutParams().width;
           imgHeight = img_recommend.getLayoutParams().height;




       }
   }





}


