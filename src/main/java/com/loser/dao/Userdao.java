package com.loser.dao;


import com.loser.entity.User;

/**
 * 用户登录、详细信息dao
 */
public interface Userdao {

    //根据用户名查询密码
    String queryPasswordByName(String username);

    //根据id查询密码
    String queryPasswordById(int id);

    //注册用户
    void addUser(User user);

}