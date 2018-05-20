package com.loser.service;

import com.loser.entity.User;
import com.loser.enums.LoginStateEnum;
import com.loser.enums.RegisterStateEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void doLogin() {
        LoginStateEnum Senum = userService.doLogin("admin","admin");
        System.out.println(Senum);
    }

    @Test
    public void doRegister() {
        User user = new User("c","a","a","a","a",null,"a");
        RegisterStateEnum registerStateEnum = userService.doRegister(user);
        System.out.println(registerStateEnum);

    }
}