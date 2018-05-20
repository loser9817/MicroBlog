package com.loser.web;

import com.loser.entity.User;
import com.loser.enums.LoginStateEnum;
import com.loser.enums.RegisterStateEnum;
import com.loser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/MicroBlog")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST)
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model) {

        LoginStateEnum stateEnum = userService.doLogin(username, password);
        if (stateEnum.getState() == 0) {
            model.addAttribute("info", stateEnum.getInfo());
            return "register";
        } else if (stateEnum.getState() == 1) {
            model.addAttribute("info", stateEnum.getInfo());
            return "login";
        }
        model.addAttribute("info", stateEnum.getInfo());
        return "forword:/list";
    }

    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public String doRegisert(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password
    ) {

        User user = new User(username, password);
        RegisterStateEnum stateEnum = userService.doRegister(user);

        if (stateEnum.getState() == 2) {
            return "detail";
        }
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list() {


    }
}
