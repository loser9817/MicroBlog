package com.loser.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.loser.entity.BlogComment;
import com.loser.entity.BlogContent;
import com.loser.entity.BlogImg;
import com.loser.entity.User;

import java.util.List;

public class Blog {

    private User user;
    private BlogContent blogContent;
    private List<BlogImg> img;
    private List<BlogComment> blogComment;

    private int commentCount;//收藏数
    private int likeCount;//点赞数

    @JsonView(View.UserSimpleView.class)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonView(View.BlogSimpleView.class)
    public BlogContent getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(BlogContent blogContent) {
        this.blogContent = blogContent;
    }

    @JsonView(View.BlogSimpleView.class)
    public List<BlogImg> getImg() {
        return img;
    }

    public void setImg(List<BlogImg> img) {
        this.img = img;
    }

    @JsonView(View.BlogDetailView.class)
    public List<BlogComment> getBlogComment() {
        return blogComment;
    }

    public void setBlogComment(List<BlogComment> blogComment) {
        this.blogComment = blogComment;
    }

    @JsonView(View.BlogSimpleView.class)
    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    @JsonView(View.BlogSimpleView.class)
    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "user=" + user +
                ", blogContent=" + blogContent +
                ", head=" + img +
                ", blogComment=" + blogComment +
                ", commentCount=" + commentCount +
                ", likeCount=" + likeCount +
                '}';
    }
}
