package com.ecloset.Bean;

import java.util.List;

public class Post {

    //这个时帖子的id，自增
    private String id;
    //发帖人的名称
    private String posterName;
    //发帖的话语
    private String saying;
    //发帖的图片
    private String img;
    //帖子的评论
    private List<String> commentLists;
    //发帖的时间
    private String postTime;
    //喜欢的数量
    private Integer likes;
    //评论的数量
    private Integer comments;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getSaying() {
        return saying;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<String> getCommentLists() {
        return commentLists;
    }

    public void setCommentLists(List<String> comment_list) {
        this.commentLists = comment_list;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }


    public Post(String id, String posterName, String saying, String img, List<String> commentLists, String postTime, Integer likes, Integer comments) {
        this.id = id;
        this.posterName = posterName;
        this.saying = saying;
        this.img = img;
        this.commentLists = commentLists;
        this.postTime = postTime;
        this.likes = likes;
        this.comments = comments;
    }





}
