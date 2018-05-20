package com.loser.dao;

import com.loser.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void addUser(){
        User user = new User("b","a","a","a","a",null,"a");
        userdao.addUser(user);
    }
}