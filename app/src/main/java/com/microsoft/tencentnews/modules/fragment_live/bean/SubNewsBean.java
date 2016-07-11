package com.microsoft.tencentnews.modules.fragment_live.bean;

/**
 * Created by Administrator on 16-7-9.
 */
public class SubNewsBean{



    private String topicImg;
    private int replyCount;
    private String videosource;
    private String topicDesc;
    private String topicSid;
    private String cover;
    private String title;
    private int  playCount;
    private String replyBoard ;

    private String sectiontitle;
    private String replyid;
    private String mp4_url;
    private int length;
    private int playersize;
    private String vid;
    private String m3u8_url;
    private String ptime;
    private String topicName;

    private Sub2NewsBean videoTopic;

    public SubNewsBean(){
    }

    public SubNewsBean(String topicImg, int replyCount, String videosource, String topicDesc, String topicSid, String cover, String title, int playCount, String replyBoard, String sectiontitle, String replyid, String mp4_url, int length, int playersize, String vid, String m3u8_url, String ptime, String topicName, Sub2NewsBean videoTopic){
        this.topicImg = topicImg;
        this.replyCount = replyCount;
        this.videosource = videosource;
        this.topicDesc = topicDesc;
        this.topicSid = topicSid;
        this.cover = cover;
        this.title = title;
        this.playCount = playCount;
        this.replyBoard = replyBoard;
        this.sectiontitle = sectiontitle;
        this.replyid = replyid;
        this.mp4_url = mp4_url;
        this.length = length;
        this.playersize = playersize;
        this.vid = vid;
        this.m3u8_url = m3u8_url;
        this.ptime = ptime;
        this.topicName = topicName;
        this.videoTopic = videoTopic;
    }

    public String getTopicImg(){
        return topicImg;
    }

    public void setTopicImg(String topicImg){
        this.topicImg = topicImg;
    }

    public int getReplyCount(){
        return replyCount;
    }

    public void setReplyCount(int replyCount){
        this.replyCount = replyCount;
    }

    public String getVideosource(){
        return videosource;
    }

    public void setVideosource(String videosource){
        this.videosource = videosource;
    }

    public String getTopicDesc(){
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc){
        this.topicDesc = topicDesc;
    }

    public String getTopicSid(){
        return topicSid;
    }

    public void setTopicSid(String topicSid){
        this.topicSid = topicSid;
    }

    public String getCover(){
        return cover;
    }

    public void setCover(String cover){
        this.cover = cover;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getPlayCount(){
        return playCount;
    }

    public void setPlayCount(int playCount){
        this.playCount = playCount;
    }

    public String getReplyBoard(){
        return replyBoard;
    }

    public void setReplyBoard(String replyBoard){
        this.replyBoard = replyBoard;
    }

    public String getSectiontitle(){
        return sectiontitle;
    }

    public void setSectiontitle(String sectiontitle){
        this.sectiontitle = sectiontitle;
    }

    public String getReplyid(){
        return replyid;
    }

    public void setReplyid(String replyid){
        this.replyid = replyid;
    }

    public String getMp4_url(){
        return mp4_url;
    }

    public void setMp4_url(String mp4_url){
        this.mp4_url = mp4_url;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getPlayersize(){
        return playersize;
    }

    public void setPlayersize(int playersize){
        this.playersize = playersize;
    }

    public String getVid(){
        return vid;
    }

    public void setVid(String vid){
        this.vid = vid;
    }

    public String getM3u8_url(){
        return m3u8_url;
    }

    public void setM3u8_url(String m3u8_url){
        this.m3u8_url = m3u8_url;
    }

    public String getPtime(){
        return ptime;
    }

    public void setPtime(String ptime){
        this.ptime = ptime;
    }

    public String getTopicName(){
        return topicName;
    }

    public void setTopicName(String topicName){
        this.topicName = topicName;
    }

    public Sub2NewsBean getVideoTopic(){
        return videoTopic;
    }

    public void setVideoTopic(Sub2NewsBean videoTopic){
        this.videoTopic = videoTopic;
    }
}
