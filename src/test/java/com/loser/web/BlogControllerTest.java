package com.loser.web;

import com.loser.dto.Blog;
import com.loser.enums.ResultStates;
import com.loser.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class BlogControllerTest {

    @Autowired
    private BlogService blogService;
    @Test
    public void list() {
    }

    @Test
    public void blogInfo() {
        ResultStates blogInfo = blogService.getBlogInfo(1);
        System.out.println(blogInfo);
    }
}