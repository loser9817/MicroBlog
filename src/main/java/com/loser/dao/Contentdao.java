package com.loser.dao;

import com.loser.dto.Blog;
import com.loser.entity.BlogComment;
import com.loser.entity.BlogImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface Contentdao {

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
}

