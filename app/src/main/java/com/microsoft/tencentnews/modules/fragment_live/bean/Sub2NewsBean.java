package com.microsoft.tencentnews.modules.fragment_live.bean;

/**
 * Created by Administrator on 16-7-10.
 */
public class Sub2NewsBean{

  /*  "alias":"姐吃的盐比你走的路还多",
            "tname":"姐的霸气你学不来",
            "ename":"T1460515714321",
            "tid":"T1460515714321"*/


    private String alias;
    private String tname;
    private String ename;
    private String tid;

    public Sub2NewsBean(){
    }

    public Sub2NewsBean(String alias, String tname, String ename, String tid){
        this.alias = alias;
        this.tname = tname;
        this.ename = ename;
        this.tid = tid;
    }

    public String getAlias(){
        return alias;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }

    public String getTname(){
        return tname;
    }

    public void setTname(String tname){
        this.tname = tname;
    }

    public String getEname(){
        return ename;
    }

    public void setEname(String ename){
        this.ename = ename;
    }

    public String getTid(){
        return tid;
    }

    public void setTid(String tid){
        this.tid = tid;
    }
}
