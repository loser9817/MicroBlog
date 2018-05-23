package com.loser.web;

import com.loser.dto.Blog;
import com.loser.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MicroBlog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Blog> list(){
        List<Blog> blogs = blogService.list();
        return blogs;
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public Blog blogInfo(@PathVariable int id){
        Blog blogInfo = blogService.getBlogInfo(id);
        return blogInfo;
    }
}
