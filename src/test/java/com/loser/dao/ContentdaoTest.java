package com.loser.dao;

import com.loser.dto.Blog;
import com.loser.entity.BlogComment;
import com.loser.entity.BlogImg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ContentdaoTest {

    @Autowired
    private Contentdao contentdao;

    @Test
    public void queryContentById() {
        Blog blog = contentdao.queryContentById(1);
        System.out.println(blog);
        List<BlogImg> blogImgs = contentdao.queryImgByContentId(1);
        //将获得的图片集合放入博客实体中
        blog.setImg(blogImgs);
        //通过id查询到微博的点赞数和评论数
        int countC = contentdao.queryCommentCountByContentId(1);
        int countL = contentdao.queryLikeCountByContentId(1);
        //将这两个值传入
        blog.setCommentCount(countC);
        blog.setLikeCount(countL);

        List<BlogComment> blogComments = contentdao.queryCommentByContentId(1);

        blog.setBlogComment(blogComments);
        System.out.println(blog);

    }

    @Test
    public void queryImgByContentId() {
        Blog blog = contentdao.queryContentById(1);
//        System.out.println(blog);
        List<BlogImg> blogImg = contentdao.queryImgByContentId(1);
        System.out.println(blogImg);
        blog.setImg(blogImg);
        blog.setLikeCount(contentdao.queryLikeCountByContentId(1));
        blog.setCommentCount(contentdao.queryCommentCountByContentId(1));
        blog.setBlogComment(contentdao.queryCommentByContentId(1));
        System.out.println(blog);
    }

    @Test
    public void queryAllContentAndUser() {

        //以下为查询微博列表service功能//TODO
        //先将所有的微博全部查询出来
        List<Blog> blogs = contentdao.queryAllContentAndUser();


        System.out.println(blogs);
    }

    @Test
    public void addBlog(){
        int i = contentdao.addBlog(2, "222222");
        System.out.println(i);
    }
}