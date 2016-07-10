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
import com.microsoft.tencentnews.modules.fragment_live.bean.SubNewsBean;

import java.util.List;

/**
 * Created by Administrator on 16-7-9.
 */
public class LiveRecycleAdapter extends RecyclerView.Adapter{

    private  Context context;
    private  List<SubNewsBean> subNewsBeenList;
    private  LayoutInflater inflater;

    private int imgWidth;
    private int imgHeight;
    private String webUrl;

    private OnRecycleViewItemClickListener03 listener;


    public LiveRecycleAdapter(Context context, List<SubNewsBean> newsBeanList){

        this.context =context;
        subNewsBeenList =newsBeanList;
        inflater = LayoutInflater.from(context);
    }


    public interface OnRecycleViewItemClickListener03 {

        void clickItem(View v,String webUrl);
    }
    public void setOnRecycleViewItemClickListener03(OnRecycleViewItemClickListener03 listener){

        this.listener=listener;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = inflater.inflate(R.layout.videolayout_live, parent, false);
        return new LiveViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        try{
            webUrl = subNewsBeenList.get(position).getM3u8_url();
            ((LiveViewHolder) holder).title_live.setText(subNewsBeenList.get(position).getTitle());
            HttpUtils.volleyLoadImage(context, imgWidth, imgHeight, subNewsBeenList.get(position).getCover(), ((LiveViewHolder) holder).background_live);
        }catch(Exception e){
        }


    }

    @Override
    public int getItemCount(){
        return subNewsBeenList.size();
    }


    class LiveViewHolder extends RecyclerView.ViewHolder{


        TextView title_live;
        ImageView background_live;

        private OnRecycleViewItemClickListener03 viewlistener;

        public LiveViewHolder(final View itemView, OnRecycleViewItemClickListener03 listener){
            super(itemView);
            title_live = (TextView) itemView.findViewById(R.id.videlTitle_live);
            background_live = (ImageView) itemView.findViewById(R.id.videobg_live);
            imgWidth = background_live.getLayoutParams().width;
            imgHeight = background_live.getLayoutParams().height;

            this.viewlistener=listener;

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    viewlistener.clickItem(itemView,webUrl);

                }
            });
        }
    }



}
