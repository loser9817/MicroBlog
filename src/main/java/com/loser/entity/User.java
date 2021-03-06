package com.loser.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.loser.dto.View;

import java.util.Date;

/**
 * 用户详细信息表userinfo实体类
 */
public class User {

    private String username;
    private String password;

    private int id;
    private String nickname;
    private String address;
    private String sex;
    private Date birthday;
    private String intro;
    private Date createTime;
    private String head;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String nickname, String address, String sex, Date birthday, String intro) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.intro = intro;
    }

    public User(int id, String username, String nickname, String address, String sex, Date birthday) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
    }

    @JsonView(View.UserDetailView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(View.UserDetailView.class)
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

    @JsonView(View.UserSimpleView.class)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonView(View.UserDetailView.class)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonView(View.UserDetailView.class)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonView(View.UserDetailView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(View.UserDetailView.class)
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @JsonView(View.UserDetailView.class)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonView(View.UserSimpleView.class)
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", nickname='" + nickname + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", intro='" + intro + '\'' +
                ", createTime=" + createTime +
                ", head='" + head + '\'' +
                '}';
    }
}
