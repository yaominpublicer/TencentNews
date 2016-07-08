package com.microsoft.tencentnews.modules.fragment_recommend.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 16-7-8.
 */
public class NewsBeanRecommend{



    private String id;
    private String articletype;
    private String flag;
    private int timestamp;
    private String time;
    private String commentid;
    private String url;
    private String title;
    @SerializedName("abstract")
    private String abstractX;
    private String chlid;
    private String origUrl;
    private int show_expr;
    private int picShowType;
    private String chlname;
    private String chlmrk;
    private String chlsicon;
    private String chlicon;
    private String uin;
    private String source;
    private String wechat;


    private CardBean card;
    private int SubAdOn;
    private String media_id;
    private String sub_flag;
    private int alg_version;
    private String seq_no;
    private String reasonInfo;
    private String reason_name;
    private List<String> thumbnails_qqnews;
    private List<String> thumbnails;
    private List<?> tag;
    private List<?> author;

    public NewsBeanRecommend(){
    }

    public NewsBeanRecommend(String id, String articletype, String flag, int timestamp, String time, String commentid, String url, String title, String abstractX, String chlid, String origUrl, int show_expr, int picShowType, String chlname, String chlmrk, String chlsicon, String chlicon, String uin, String source, String wechat, CardBean card, int subAdOn, String media_id, String sub_flag, int alg_version, String seq_no, String reasonInfo, String reason_name, List<String> thumbnails_qqnews, List<String> thumbnails, List<?> tag, List<?> author){
        this.id = id;
        this.articletype = articletype;
        this.flag = flag;
        this.timestamp = timestamp;
        this.time = time;
        this.commentid = commentid;
        this.url = url;
        this.title = title;
        this.abstractX = abstractX;
        this.chlid = chlid;
        this.origUrl = origUrl;
        this.show_expr = show_expr;
        this.picShowType = picShowType;
        this.chlname = chlname;
        this.chlmrk = chlmrk;
        this.chlsicon = chlsicon;
        this.chlicon = chlicon;
        this.uin = uin;
        this.source = source;
        this.wechat = wechat;
        this.card = card;
        SubAdOn = subAdOn;
        this.media_id = media_id;
        this.sub_flag = sub_flag;
        this.alg_version = alg_version;
        this.seq_no = seq_no;
        this.reasonInfo = reasonInfo;
        this.reason_name = reason_name;
        this.thumbnails_qqnews = thumbnails_qqnews;
        this.thumbnails = thumbnails;
        this.tag = tag;
        this.author = author;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getArticletype(){
        return articletype;
    }

    public void setArticletype(String articletype){
        this.articletype = articletype;
    }

    public String getFlag(){
        return flag;
    }

    public void setFlag(String flag){
        this.flag = flag;
    }

    public int getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(int timestamp){
        this.timestamp = timestamp;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getCommentid(){
        return commentid;
    }

    public void setCommentid(String commentid){
        this.commentid = commentid;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAbstractX(){
        return abstractX;
    }

    public void setAbstractX(String abstractX){
        this.abstractX = abstractX;
    }

    public String getChlid(){
        return chlid;
    }

    public void setChlid(String chlid){
        this.chlid = chlid;
    }

    public String getOrigUrl(){
        return origUrl;
    }

    public void setOrigUrl(String origUrl){
        this.origUrl = origUrl;
    }

    public int getShow_expr(){
        return show_expr;
    }

    public void setShow_expr(int show_expr){
        this.show_expr = show_expr;
    }

    public int getPicShowType(){
        return picShowType;
    }

    public void setPicShowType(int picShowType){
        this.picShowType = picShowType;
    }

    public String getChlname(){
        return chlname;
    }

    public void setChlname(String chlname){
        this.chlname = chlname;
    }

    public String getChlmrk(){
        return chlmrk;
    }

    public void setChlmrk(String chlmrk){
        this.chlmrk = chlmrk;
    }

    public String getChlsicon(){
        return chlsicon;
    }

    public void setChlsicon(String chlsicon){
        this.chlsicon = chlsicon;
    }

    public String getChlicon(){
        return chlicon;
    }

    public void setChlicon(String chlicon){
        this.chlicon = chlicon;
    }

    public String getUin(){
        return uin;
    }

    public void setUin(String uin){
        this.uin = uin;
    }

    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getWechat(){
        return wechat;
    }

    public void setWechat(String wechat){
        this.wechat = wechat;
    }

    public CardBean getCard(){
        return card;
    }

    public void setCard(CardBean card){
        this.card = card;
    }

    public int getSubAdOn(){
        return SubAdOn;
    }

    public void setSubAdOn(int SubAdOn){
        this.SubAdOn = SubAdOn;
    }

    public String getMedia_id(){
        return media_id;
    }

    public void setMedia_id(String media_id){
        this.media_id = media_id;
    }

    public String getSub_flag(){
        return sub_flag;
    }

    public void setSub_flag(String sub_flag){
        this.sub_flag = sub_flag;
    }

    public int getAlg_version(){
        return alg_version;
    }

    public void setAlg_version(int alg_version){
        this.alg_version = alg_version;
    }

    public String getSeq_no(){
        return seq_no;
    }

    public void setSeq_no(String seq_no){
        this.seq_no = seq_no;
    }

    public String getReasonInfo(){
        return reasonInfo;
    }

    public void setReasonInfo(String reasonInfo){
        this.reasonInfo = reasonInfo;
    }

    public String getReason_name(){
        return reason_name;
    }

    public void setReason_name(String reason_name){
        this.reason_name = reason_name;
    }

    public List<String> getThumbnails_qqnews(){
        return thumbnails_qqnews;
    }

    public void setThumbnails_qqnews(List<String> thumbnails_qqnews){
        this.thumbnails_qqnews = thumbnails_qqnews;
    }

    public List<String> getThumbnails(){
        return thumbnails;
    }

    public void setThumbnails(List<String> thumbnails){
        this.thumbnails = thumbnails;
    }

    public List<?> getTag(){
        return tag;
    }

    public void setTag(List<?> tag){
        this.tag = tag;
    }

    public List<?> getAuthor(){
        return author;
    }

    public void setAuthor(List<?> author){
        this.author = author;
    }

    public static class CardBean{
        private String chlname;
        private String chlid;
        private String desc;
        private String icon;
        private String uin;
        private String intro;
        private int msgEntry;
        private String wechat;

        public CardBean(){
        }

        public CardBean(String chlname, String chlid, String desc, String icon, String uin, String intro, int msgEntry, String wechat){
            this.chlname = chlname;
            this.chlid = chlid;
            this.desc = desc;
            this.icon = icon;
            this.uin = uin;
            this.intro = intro;
            this.msgEntry = msgEntry;
            this.wechat = wechat;
        }

        public String getChlname(){
            return chlname;
        }

        public void setChlname(String chlname){
            this.chlname = chlname;
        }

        public String getChlid(){
            return chlid;
        }

        public void setChlid(String chlid){
            this.chlid = chlid;
        }

        public String getDesc(){
            return desc;
        }

        public void setDesc(String desc){
            this.desc = desc;
        }

        public String getIcon(){
            return icon;
        }

        public void setIcon(String icon){
            this.icon = icon;
        }

        public String getUin(){
            return uin;
        }

        public void setUin(String uin){
            this.uin = uin;
        }

        public String getIntro(){
            return intro;
        }

        public void setIntro(String intro){
            this.intro = intro;
        }

        public int getMsgEntry(){
            return msgEntry;
        }

        public void setMsgEntry(int msgEntry){
            this.msgEntry = msgEntry;
        }

        public String getWechat(){
            return wechat;
        }

        public void setWechat(String wechat){
            this.wechat = wechat;
        }
    }
}
