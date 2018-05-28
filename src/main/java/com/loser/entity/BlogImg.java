package com.loser.entity;

public class BlogImg {

    private int id;
    private String img;
    private int contentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    @Override
    public String toString() {
        return "BlogImg{" +
                "id=" + id +
                ", head='" + img + '\'' +
                ", contentId=" + contentId +
                '}';
    }
}
