package com.loser.dao;

import com.loser.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserdaoTest {

    @Autowired
    private Userdao userdao;

    @Test
    public void queryUser() {
        String password = userdao.queryPasswordByName("1admin");
        System.out.println(password);
    }

    @Test
    public void addUser() {
//        User user = new User("b", "a", "a", "a", "a", null, "a");
//        userdao.addUser(user);
    }

//    @Test
//    0public void setUserInfoById() {
//        User user = new User(13, "", "realname", "address", "sex", new Date());
//        int i = userdao.setUserInfoById(user);
//        System.out.println("返回值为" + i + "User:" + user);
//    }

    @Test
    public void setUserIntroById() {
        String intro = "intro";
        int i = userdao.setUserIntroById(1000000, intro);
        System.out.println("返回值为" + i);
    }
}