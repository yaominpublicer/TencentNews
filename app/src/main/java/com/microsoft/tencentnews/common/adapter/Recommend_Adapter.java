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

    private List<NewsBeanRecommend> list;
    private Context context;
    private int imgWidth;
    private int imgHeight;
    private LayoutInflater inflater;
    private OnRecycleViewItemClickListener02 listener;
    private String webur02;

    public Recommend_Adapter(Context context, List<NewsBeanRecommend> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    public interface OnRecycleViewItemClickListener02{

        void itemClick(View v, String url);
    }

    public void SetOnReCycleViewItemClickListener02(OnRecycleViewItemClickListener02 listener){
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View recommendView = inflater.inflate(R.layout.itemlayout_recommend, parent, false);
        RecommendViewHolder recommendViewHolder = new RecommendViewHolder(recommendView, listener);
        return recommendViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        try{

            ((RecommendViewHolder) holder).title_recommend.setText(list.get(position).getTitle());
            ((RecommendViewHolder) holder).comment_recommend.setText(list.get(position).getReason_name());
            webur02 = list.get(position).getUrl();
            String imgurl = list.get(position).getThumbnails_qqnews().get(0);
            //  Log.e("recommendadapter","onBindViewHolder: ---"+imgurl);
            HttpUtils.volleyLoadImage(context, imgWidth, imgHeight, imgurl, ((RecommendViewHolder) holder).img_recommend);
            // Log.e("recommendadapter","onBindViewHolder: ---test volley-----");
        }catch(Exception e){


        }
    }

    @Override
    public int getItemCount(){
        if(list.size() == 0){
            return 20;
        }else{
            return list.size();
        }
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder{

        ImageView img_recommend;
        TextView title_recommend;
        TextView comment_recommend;
        private OnRecycleViewItemClickListener02 listener02 = null;

        public RecommendViewHolder(final View itemView, final OnRecycleViewItemClickListener02 listener){
            super(itemView);
            img_recommend = (ImageView) itemView.findViewById(R.id.item_img_recommend);
            title_recommend = ((TextView) itemView.findViewById(R.id.item_title_recommend));
            comment_recommend = (TextView) itemView.findViewById(R.id.item_comment_recommend);
            imgWidth = img_recommend.getLayoutParams().width;
            imgHeight = img_recommend.getLayoutParams().height;
            this.listener02 = listener;
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(listener02 != null){
                        listener02.itemClick(itemView, webur02);
                    }
                }
            });
        }
    }
}


