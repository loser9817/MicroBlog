package com.loser.web;

import com.loser.entity.User;
import com.loser.enums.LoginStateEnum;
import com.loser.enums.RegisterStateEnum;
import com.loser.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-web.xml"})
public class LoginControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        LoginStateEnum stateEnum = userService.doLogin("admin", "admin");
        System.out.println(stateEnum);
    }

    @Test
    public void register() {
        User user = new User("d","","","a","a",null,"a");
        RegisterStateEnum stateEnum = userService.doRegister(user);
        System.out.println(stateEnum);
    }
}