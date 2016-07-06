package com.microsoft.tencentnews.common.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.microsoft.tencentnews.R;

import java.util.List;

/**
 * Created by Administrator on 16-7-6.
 */
public class News_newsAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<String> interfaceList;
    private final LayoutInflater inflater;

    public News_newsAdapter(Context context, List<String> interfaceList){

        this.context=context;
        this.interfaceList = interfaceList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount(){
        return interfaceList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View inflateView = inflater.inflate(R.layout.itemlayout_recycleview_news_news, parent, false);
        MyViewHolder myHolder=new MyViewHolder(inflateView);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        ((MyViewHolder) holder).titleText.setText(interfaceList.get(position));
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
        }
    }



}
