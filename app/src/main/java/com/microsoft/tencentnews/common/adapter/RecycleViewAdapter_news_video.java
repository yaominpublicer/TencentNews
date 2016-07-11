package com.microsoft.tencentnews.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microsoft.tencentnews.R;
import com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_video.bean.SubNewsBean_news_video;

import java.util.List;

/**
 * Created by Administrator on 16-7-11.
 */
public class RecycleViewAdapter_news_video extends RecyclerView.Adapter{

    private Context context;
    private List<SubNewsBean_news_video> list;
    private final LayoutInflater inflater;

    public RecycleViewAdapter_news_video(Context context, List<SubNewsBean_news_video> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = inflater.inflate(R.layout.itemlayout_news_video, parent, false);
        NewsVideoViewHolder holder = new NewsVideoViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        if(holder instanceof NewsVideoViewHolder){
        }
    }

    @Override
    public int getItemCount(){
        if(list.size() == 0 || list == null){
            return 20;
        }else{
            return list.size();
        }
    }

    class NewsVideoViewHolder extends RecyclerView.ViewHolder{

        public NewsVideoViewHolder(View itemView){
            super(itemView);
        }
    }
}
