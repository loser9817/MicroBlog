package com.loser.service;

import com.loser.dao.Blogdao;
import com.loser.dto.Blog;
import com.loser.entity.BlogImg;
import com.loser.enums.Result;
import com.loser.enums.ResultStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private Blogdao blogdao;

    public ResultStates<List<Blog>> list() {

        List<Blog> blogs = blogdao.queryAllContentAndUser();

        for (int i = 0; i < blogs.size(); i++) {
            //通过索引i获得微博实体从而获得单个微博id
            Blog blog = blogs.get(i);
            int contentid = blog.getBlogContent().getId();
            //通过微博id查询微博的图片
            List<BlogImg> blogImgs = blogdao.queryImgByContentId(contentid);
            //将获得的图片集合放入博客实体中
            blog.setImg(blogImgs);
            //通过id查询到微博的点赞数和评论数
            int countC = blogdao.queryCommentCountByContentId(contentid);
            int countL = blogdao.queryLikeCountByContentId(contentid);
            //将这两个值传入
            blog.setCommentCount(countC);
            blog.setLikeCount(countL);
            blogs.set(i, blog);
        }
        //返回规范的接口
        return new ResultStates<List<Blog>>(Result.BLOG_QUERY_SUCCESS, blogs);
    }

    /*
     *  根据微博id获取单个微博详细
     */
    public ResultStates<Blog> getBlogInfo(int id) {
        //根据传入id查询相应的微博正文和用户
        Blog blog = blogdao.queryContentById(id);
        //根据id查询微博图片，将图片传入微博对象
        blog.setImg(blogdao.queryImgByContentId(id));
        //将点赞数，评论数和评论查询并传入微博对象
        blog.setLikeCount(blogdao.queryLikeCountByContentId(id));
        blog.setCommentCount(blogdao.queryCommentCountByContentId(id));
        blog.setBlogComment(blogdao.queryCommentByContentId(id));
        return new ResultStates<Blog>(Result.BLOG_QUERY_SUCCESS, blog);
    }

    public ResultStates<Result> addBlog(int id, String content) {

        if (blogdao.addBlog(id, content) == 1){
            return new ResultStates<Result>(Result.BLOG_ADD_SUCCESS);
        }
        return new ResultStates<Result>(Result.BLOG_ADD_ERROR);
    }

    public ResultStates<Result> like(int userId, int contentId) {

        //查找id是否存在，i为1则已经点赞了，为0则还未点赞
        if (blogdao.queryLikeById(userId, contentId) == 0) {

            //还未点赞，执行点赞操作
            if (blogdao.likeBlog(userId, contentId) == 1) {
                //点赞成功
                return new ResultStates<Result>(Result.BLOG_LIKE_SUCCESS);
            }
        }
        //已经点过赞了，取消点赞
        if (blogdao.deleteLike(userId, contentId) == 1) {
            //取消点赞成功
            return new ResultStates<Result>(Result.BLOG_LIKE_CANCLE_SUCCESS);
        }

        //点赞失败
        return new ResultStates<Result>(Result.BLOG_LIKE_ERROR);

    }
}
