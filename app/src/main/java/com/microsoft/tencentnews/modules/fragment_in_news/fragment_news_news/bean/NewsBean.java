package com.microsoft.tencentnews.modules.fragment_in_news.fragment_news_news.bean;

import java.util.List;

/**
 * Created by Administrator on 16-7-7.
 */
public class NewsBean{

    private List<NewsContent> newslist;



    public List<NewsContent> getNewslist(){
        return newslist;
    }

    public void setNewslist(List<NewsContent> newslist){
        this.newslist = newslist;
    }






    public static class NewsContent{


        private String uinnick;
        private String title;
        private String surl;
        private String short_url;
        private String url;
        private String time;
        private long timestamp;

        private List<String> thumbnails;
        private String source;
        private int imagecount;
        private List<String> thumbnails_qqnews;

       private List<String> thumbnails_qqnews_photo;

        public NewsContent(String uinnick, String title, String surl, String short_url, String url, String time, long timestamp, List<String> thumbnails, String source, int imagecount, List<String> thumbnails_qqnews, List<String> thumbnails_qqnews_photo){
            this.uinnick = uinnick;
            this.title = title;
            this.surl = surl;
            this.short_url = short_url;
            this.url = url;
            this.time = time;
            this.timestamp = timestamp;
            this.thumbnails = thumbnails;
            this.source = source;
            this.imagecount = imagecount;
            this.thumbnails_qqnews = thumbnails_qqnews;
            this.thumbnails_qqnews_photo = thumbnails_qqnews_photo;
        }

        public String getUinnick(){
            return uinnick;
        }

        public void setUinnick(String uinnick){
            this.uinnick = uinnick;
        }

        public String getTitle(){
            return title;
        }

        public void setTitle(String title){
            this.title = title;
        }

        public String getSurl(){
            return surl;
        }

        public void setSurl(String surl){
            this.surl = surl;
        }

        public String getShort_url(){
            return short_url;
        }

        public void setShort_url(String short_url){
            this.short_url = short_url;
        }

        public String getUrl(){
            return url;
        }

        public void setUrl(String url){
            this.url = url;
        }

        public String getTime(){
            return time;
        }

        public void setTime(String time){
            this.time = time;
        }

        public long getTimestamp(){
            return timestamp;
        }

        public void setTimestamp(long timestamp){
            this.timestamp = timestamp;
        }

        public List<String> getThumbnails(){
            return thumbnails;
        }

        public void setThumbnails(List<String> thumbnails){
            this.thumbnails = thumbnails;
        }

        public String getSource(){
            return source;
        }

        public void setSource(String source){
            this.source = source;
        }

        public int getImagecount(){
            return imagecount;
        }

        public void setImagecount(int imagecount){
            this.imagecount = imagecount;
        }

        public List<String> getThumbnails_qqnews(){
            return thumbnails_qqnews;
        }

        public void setThumbnails_qqnews(List<String> thumbnails_qqnews){
            this.thumbnails_qqnews = thumbnails_qqnews;
        }

        public List<String> getThumbnails_qqnews_photo(){
            return thumbnails_qqnews_photo;
        }

        public void setThumbnails_qqnews_photo(List<String> thumbnails_qqnews_photo){
            this.thumbnails_qqnews_photo = thumbnails_qqnews_photo;
        }
    }

}
