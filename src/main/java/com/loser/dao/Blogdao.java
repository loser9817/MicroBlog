package com.loser.dao;

import com.loser.dto.Blog;
import com.loser.entity.BlogComment;
import com.loser.entity.BlogImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface Blogdao {

    //正文id查微博正文
    Blog queryContentById(int id);

    //正文id查微博图片
    List<BlogImg> queryImgByContentId(int id);

    //正文id查微博评论
    List<BlogComment> queryCommentByContentId(int id);

    //查询所有的微博和微博对应的用户名和头像,一起查为了减少查询次数
    List<Blog> queryAllContentAndUser();

    //根据微博id查询评论数
    int queryCommentCountByContentId(int id);

    //根据微博id查询点赞数
    int queryLikeCountByContentId(int id);

    //新增一个微博
    int addBlog(@Param("userId") int userId, @Param("content")String content);
    //微博添加图片
    //TODO
    

    //根据userid和contentid查询userid的用户是否已经在contentid中点赞
    int queryLikeById(@Param("userId") int userId, @Param("contentId") int contentId);
    //点赞博客
    int likeBlog(@Param("userId") int userId, @Param("contentId") int contentId);
    //取消点赞
    int deleteLike(@Param("userId") int userId, @Param("contentId") int contentId);
}

