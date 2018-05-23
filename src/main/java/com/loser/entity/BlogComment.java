package com.loser.entity;

import java.util.Date;

public class BlogComment {

    private int id;
    private String comment;
    private Date createTime;
    private int contentId;
    private int userId;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                ", contentId=" + contentId +
                ", userId=" + userId +
                '}';
    }
}
