package com.loser.entity;

import java.util.Date;

/**
 * 用户详细信息表userinfo实体类
 */
public class User {

    private String username;
    private String password;

    private int id;
    private String realname;
    private String address;
    private String sex;
    private Date birthday;
    private String intro;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String realname, String address, String sex, Date birthday, String intro) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.intro = intro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

}
