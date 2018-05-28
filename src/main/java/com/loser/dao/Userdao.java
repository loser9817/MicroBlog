package com.loser.dao;


import com.loser.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户登录、详细信息dao
 */
public interface Userdao {

    //根据用户名查询密码
    String queryPasswordByName(String username);

    //注册用户
    void addUser(User user);//TODO 改void为int

    //查询用户详细信息
    User queryUseInforById(int id);

    //根据id设置详细信息
    int setUserInfoById(User user);

    //根据id设置个人简介
    int setUserIntroById(@Param("id") int id, @Param("intro") String intro);

}