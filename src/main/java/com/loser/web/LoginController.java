package com.loser.web;

import com.loser.entity.User;
import com.loser.enums.LoginStateEnum;
import com.loser.enums.RegisterStateEnum;
import com.loser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/MicroBlog")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST)
    public LoginStateEnum doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password) {

        LoginStateEnum stateEnum = userService.doLogin(username, password);
        if (stateEnum.getState() == 0) {
            return stateEnum;
        }
        return stateEnum;
    }

    @RequestMapping(value = "/doregister", method = RequestMethod.POST)
    public RegisterStateEnum doRegisert(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password
    ) {

        User user = new User(username, password);
        RegisterStateEnum stateEnum = userService.doRegister(user);

        if (stateEnum.getState() == 2) {
            return stateEnum;
        }
        return stateEnum;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public void list() {
//
//
//    }
}
