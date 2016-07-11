package com.microsoft.tencentnews.modules.fragment_in_news.fragment_new_video.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 16-7-11.
 */
public class SubNewsBean_news_video{

    /**
     * id : 20160710V02QV300
     * thumbnails_qqnews : ["http://puui.qpic.cn/qqvideo_ori/0/j0312tdq9yi_496_280/0"]
     * thumbnails : ["http://puui.qpic.cn/qqvideo_ori/0/j0312tdq9yi_496_280/0"]
     * articletype : 4
     * flag : 3
     * timestamp : 1468136261
     * time : 2016-07-10 15:37:41
     * commentid : 1460500119
     * url : http://view.inews.qq.com/a/20160710V02QV300
     * title : 三个美女遇到劫色 最后劫匪竟身体吃不消
     * tag : []
     * abstract : ...
     * author : []
     * chlid : 5206204
     * origUrl :
     * show_expr : 1
     * hasVideo : 1
     * picShowType : 0
     * chlname : 七上八下
     * chlmrk : 搞笑娱乐生活小窍门牛人傻缺宠物宝宝搞笑视频
     * chlsicon : http://inews.gtimg.com/newsapp_ls/0/375479887_200200/0
     * chlicon : http://inews.gtimg.com/newsapp_ls/0/375479887_200200/0
     * uin : ec8bb1459b9d84100312bf035bb43cd4d0
     * source : 七上八下
     * card : {"chlname":"七上八下","chlid":"5206204","desc":"搞笑娱乐生活小窍门牛人傻缺宠物宝宝搞笑视频","icon":"http://inews.gtimg.com/newsapp_ls/0/375479887_200200/0","uin":"ec8bb1459b9d84100312bf035bb43cd4d0","intro":"","msgEntry":1}
     * PlacementId :
     * SubAdOn : 0
     * video_channel : {"egid":"20160710V02QV300","eid":"1","openSupport":1,"video":{"videosourcetype":1,"playmode":1,"duration":"09:11","vid":"j0312tdq9yi","desc":"","img":"http://puui.qpic.cn/qqvideo_ori/0/j0312tdq9yi_496_280/0","playurl":"http://inews.qq.com/webVideo?vid=j0312tdq9yi&img=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_ls%2F0%2F403253759_640480%2F0&appver=","width":640,"height":400,"playcount":202424}}
     * commentPlacementId : 9007477470660515023
     * openAdsComment : 0
     * media_id : 5206204
     * videoTotalTime : 09:11
     * seq_no : 206768236253
     * alg_version : 1
     * reasonInfo :
     * show_source : 1
     */

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
    private int hasVideo;
    private int picShowType;
    private String chlname;
    private String chlmrk;
    private String chlsicon;
    private String chlicon;
    private String uin;
    private String source;
    /**
     * chlname : 七上八下
     * chlid : 5206204
     * desc : 搞笑娱乐生活小窍门牛人傻缺宠物宝宝搞笑视频
     * icon : http://inews.gtimg.com/newsapp_ls/0/375479887_200200/0
     * uin : ec8bb1459b9d84100312bf035bb43cd4d0
     * intro :
     * msgEntry : 1
     */

    private CardBean card;
    private String PlacementId;
    private int SubAdOn;
    /**
     * egid : 20160710V02QV300
     * eid : 1
     * openSupport : 1
     * video : {"videosourcetype":1,"playmode":1,"duration":"09:11","vid":"j0312tdq9yi","desc":"","img":"http://puui.qpic.cn/qqvideo_ori/0/j0312tdq9yi_496_280/0","playurl":"http://inews.qq.com/webVideo?vid=j0312tdq9yi&img=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_ls%2F0%2F403253759_640480%2F0&appver=","width":640,"height":400,"playcount":202424}
     */

    private VideoChannelBean video_channel;
    private String commentPlacementId;
    private int openAdsComment;
    private String media_id;
    private String videoTotalTime;
    private String seq_no;
    private int alg_version;
    private String reasonInfo;
    private int show_source;
    private List<String> thumbnails_qqnews;
    private List<String> thumbnails;
    private List<?> tag;
    private List<?> author;

    public SubNewsBean_news_video(){
    }

    public SubNewsBean_news_video(String id, String articletype, String flag, int timestamp, String time, String commentid, String url, String title, String abstractX, String chlid, String origUrl, int show_expr, int hasVideo, int picShowType, String chlname, String chlmrk, String chlsicon, String chlicon, String uin, String source, CardBean card, String placementId, int subAdOn, VideoChannelBean video_channel, String commentPlacementId, int openAdsComment, String media_id, String videoTotalTime, String seq_no, int alg_version, String reasonInfo, int show_source, List<String> thumbnails_qqnews, List<String> thumbnails, List<?> tag, List<?> author){
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
        this.hasVideo = hasVideo;
        this.picShowType = picShowType;
        this.chlname = chlname;
        this.chlmrk = chlmrk;
        this.chlsicon = chlsicon;
        this.chlicon = chlicon;
        this.uin = uin;
        this.source = source;
        this.card = card;
        PlacementId = placementId;
        SubAdOn = subAdOn;
        this.video_channel = video_channel;
        this.commentPlacementId = commentPlacementId;
        this.openAdsComment = openAdsComment;
        this.media_id = media_id;
        this.videoTotalTime = videoTotalTime;
        this.seq_no = seq_no;
        this.alg_version = alg_version;
        this.reasonInfo = reasonInfo;
        this.show_source = show_source;
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

    public int getHasVideo(){
        return hasVideo;
    }

    public void setHasVideo(int hasVideo){
        this.hasVideo = hasVideo;
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

    public CardBean getCard(){
        return card;
    }

    public void setCard(CardBean card){
        this.card = card;
    }

    public String getPlacementId(){
        return PlacementId;
    }

    public void setPlacementId(String PlacementId){
        this.PlacementId = PlacementId;
    }

    public int getSubAdOn(){
        return SubAdOn;
    }

    public void setSubAdOn(int SubAdOn){
        this.SubAdOn = SubAdOn;
    }

    public VideoChannelBean getVideo_channel(){
        return video_channel;
    }

    public void setVideo_channel(VideoChannelBean video_channel){
        this.video_channel = video_channel;
    }

    public String getCommentPlacementId(){
        return commentPlacementId;
    }

    public void setCommentPlacementId(String commentPlacementId){
        this.commentPlacementId = commentPlacementId;
    }

    public int getOpenAdsComment(){
        return openAdsComment;
    }

    public void setOpenAdsComment(int openAdsComment){
        this.openAdsComment = openAdsComment;
    }

    public String getMedia_id(){
        return media_id;
    }

    public void setMedia_id(String media_id){
        this.media_id = media_id;
    }

    public String getVideoTotalTime(){
        return videoTotalTime;
    }

    public void setVideoTotalTime(String videoTotalTime){
        this.videoTotalTime = videoTotalTime;
    }

    public String getSeq_no(){
        return seq_no;
    }

    public void setSeq_no(String seq_no){
        this.seq_no = seq_no;
    }

    public int getAlg_version(){
        return alg_version;
    }

    public void setAlg_version(int alg_version){
        this.alg_version = alg_version;
    }

    public String getReasonInfo(){
        return reasonInfo;
    }

    public void setReasonInfo(String reasonInfo){
        this.reasonInfo = reasonInfo;
    }

    public int getShow_source(){
        return show_source;
    }

    public void setShow_source(int show_source){
        this.show_source = show_source;
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

        public CardBean(){
        }

        public CardBean(String chlname, String chlid, String desc, String icon, String uin, String intro, int msgEntry){
            this.chlname = chlname;
            this.chlid = chlid;
            this.desc = desc;
            this.icon = icon;
            this.uin = uin;
            this.intro = intro;
            this.msgEntry = msgEntry;
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
    }

    public static class VideoChannelBean{
        private String egid;
        private String eid;
        private int openSupport;
        /**
         * videosourcetype : 1
         * playmode : 1
         * duration : 09:11
         * vid : j0312tdq9yi
         * desc :
         * img : http://puui.qpic.cn/qqvideo_ori/0/j0312tdq9yi_496_280/0
         * playurl : http://inews.qq.com/webVideo?vid=j0312tdq9yi&img=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_ls%2F0%2F403253759_640480%2F0&appver=
         * width : 640
         * height : 400
         * playcount : 202424
         */

        private VideoBean video;

        public VideoChannelBean(){
        }

        public VideoChannelBean(String egid, String eid, int openSupport, VideoBean video){
            this.egid = egid;
            this.eid = eid;
            this.openSupport = openSupport;
            this.video = video;
        }

        public String getEgid(){
            return egid;
        }

        public void setEgid(String egid){
            this.egid = egid;
        }

        public String getEid(){
            return eid;
        }

        public void setEid(String eid){
            this.eid = eid;
        }

        public int getOpenSupport(){
            return openSupport;
        }

        public void setOpenSupport(int openSupport){
            this.openSupport = openSupport;
        }

        public VideoBean getVideo(){
            return video;
        }

        public void setVideo(VideoBean video){
            this.video = video;
        }

        public static class VideoBean{
            private int videosourcetype;
            private int playmode;
            private String duration;
            private String vid;
            private String desc;
            private String img;
            private String playurl;
            private int width;
            private int height;
            private int playcount;

            public VideoBean(){
            }

            public VideoBean(int videosourcetype, int playmode, String duration, String vid, String desc, String img, String playurl, int width, int height, int playcount){
                this.videosourcetype = videosourcetype;
                this.playmode = playmode;
                this.duration = duration;
                this.vid = vid;
                this.desc = desc;
                this.img = img;
                this.playurl = playurl;
                this.width = width;
                this.height = height;
                this.playcount = playcount;
            }

            public int getVideosourcetype(){
                return videosourcetype;
            }

            public void setVideosourcetype(int videosourcetype){
                this.videosourcetype = videosourcetype;
            }

            public int getPlaymode(){
                return playmode;
            }

            public void setPlaymode(int playmode){
                this.playmode = playmode;
            }

            public String getDuration(){
                return duration;
            }

            public void setDuration(String duration){
                this.duration = duration;
            }

            public String getVid(){
                return vid;
            }

            public void setVid(String vid){
                this.vid = vid;
            }

            public String getDesc(){
                return desc;
            }

            public void setDesc(String desc){
                this.desc = desc;
            }

            public String getImg(){
                return img;
            }

            public void setImg(String img){
                this.img = img;
            }

            public String getPlayurl(){
                return playurl;
            }

            public void setPlayurl(String playurl){
                this.playurl = playurl;
            }

            public int getWidth(){
                return width;
            }

            public void setWidth(int width){
                this.width = width;
            }

            public int getHeight(){
                return height;
            }

            public void setHeight(int height){
                this.height = height;
            }

            public int getPlaycount(){
                return playcount;
            }

            public void setPlaycount(int playcount){
                this.playcount = playcount;
            }
        }
    }
}
