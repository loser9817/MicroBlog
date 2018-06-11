package com.loser.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MicroBlog")
public class GotoController {

    @RequestMapping("/registerpage")
    public String registerPage(){
        return "register";
    }
}
