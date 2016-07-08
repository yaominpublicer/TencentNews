package com.microsoft.tencentnews.modules.fragment_recommend.bean;

import java.util.List;

/**
 * Created by Administrator on 16-7-8.
 */
public class MainNewsBean{

    private List<NewsBeanRecommend> newslist;

    public MainNewsBean(){
    }

    public MainNewsBean(List<NewsBeanRecommend> newslist){
        this.newslist = newslist;
    }

    public List<NewsBeanRecommend> getNewslist(){
        return newslist;
    }

    public void setNewslist(List<NewsBeanRecommend> newslist){
        this.newslist = newslist;
    }
}
