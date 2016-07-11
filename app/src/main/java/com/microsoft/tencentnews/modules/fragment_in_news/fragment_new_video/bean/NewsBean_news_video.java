package com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_video.bean;

import java.util.List;

/**
 * Created by Administrator on 16-7-11.
 */
public class NewsBean_news_video{

    private List<SubNewsBean_news_video> newslist;

    public NewsBean_news_video(){
    }

    public NewsBean_news_video(List<SubNewsBean_news_video> newslist){
        this.newslist = newslist;
    }

    public List<SubNewsBean_news_video> getNewslist(){
        return newslist;
    }

    public void setNewslist(List<SubNewsBean_news_video> newslist){
        this.newslist = newslist;
    }




}
