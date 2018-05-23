package com.loser.service;

import com.loser.dao.Contentdao;
import com.loser.dto.Blog;
import com.loser.entity.BlogImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private Contentdao contentdao;

    public List<Blog> list(){

        List<Blog> blogs = contentdao.queryAllContentAndUser();

        for (int i = 0; i < blogs.size(); i++) {
            //通过索引i获得微博实体从而获得单个微博id
            Blog blog = blogs.get(i);
            int contentid = blog.getBlogContent().getId();
            //通过微博id查询微博的图片
            List<BlogImg> blogImgs = contentdao.queryImgByContentId(contentid);
            //将获得的图片集合放入博客实体中
            blog.setImg(blogImgs);
            //通过id查询到微博的点赞数和评论数
            int countC = contentdao.queryCommentCountByContentId(contentid);
            int countL = contentdao.queryLikeCountByContentId(contentid);
            //将这两个值传入
            blog.setCommentCount(countC);
            blog.setLikeCount(countL);
            blogs.set(i,blog);
        }
        return blogs;
    }

    /*
     *  根据微博id获取单个微博详细
     */
    public Blog getBlogInfo(int id){
        //根据传入id查询相应的微博正文和用户
        Blog blog = contentdao.queryContentById(id);
        //根据id查询微博图片，将图片传入微博对象
        blog.setImg(contentdao.queryImgByContentId(1));
        //将点赞数，评论数和评论查询并传入微博对象
        blog.setLikeCount(contentdao.queryLikeCountByContentId(1));
        blog.setCommentCount(contentdao.queryCommentCountByContentId(1));
        blog.setBlogComment(contentdao.queryCommentByContentId(1));
        return blog;
    }
}
