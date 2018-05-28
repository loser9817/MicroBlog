package com.loser.web;

import com.loser.enums.ResultStates;
import com.loser.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MicroBlog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ResultStates list() {
        ResultStates blogs = blogService.list();
        System.out.println(blogs);
        return blogs;
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public ResultStates blogInfo(@PathVariable int id) {
        ResultStates blogInfo = blogService.getBlogInfo(id);
        return blogInfo;
    }

    @RequestMapping(value = "/blog" ,method = RequestMethod.POST)
    public ResultStates addBlog(@RequestParam(value = "userId",required = false,defaultValue = "0") int userId,
                                @RequestParam(value = "content") String content){

        System.out.println(userId);
        return blogService.addBlog(userId,content);
    }

    @RequestMapping(value = "/{userId}/like/blog/{contentId}"
            , method = RequestMethod.GET)  //这里应该是insert（插入点赞）或delete（删除取消点赞）操作，但使用了GET
    public ResultStates likeBlog(@PathVariable("contentId") int contentId,
                                 @PathVariable("userId") int userId) {

        return blogService.like(userId, contentId);
    }
}
