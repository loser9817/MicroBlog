package com.loser.enums;

/**
 * @Parm state  状态码
 * 1xx 表示登陆相关的状态
 * 100：登陆成功
 * 101：密码错误
 * 102：用户未注册
 * <p>
 * 2xx 表示注册相关的状态
 * 200：注册成功
 * 201：用户名已被注册
 * 202：注册信息错误
 * <p>
 * 3xx 表示博客相关的状态
 * 300：查询成功
 * 301：查询失败
 * <p>
 * 310：点赞成功
 * 311：取消点赞
 * 312: 点赞失败
 * <p>
 * 320：发表微博成功
 * 321：发表微博失败
 *
 * 400：更改用户信息成功
 * 401：更改用户信息失败
 *
 * @Parm message  错误信息
 */

public enum Result {
    LOGIN_SUCCESS(100, "登陆成功"),
    LOGIN_PSW_ERRPR(101, "密码错误"),
    LOGIN_USER_UNDEFINED(102, "用户未注册"),


    REGISTER_SUCCESS(200, "注册成功"),
    REGISTER_USER_EXISTS(201, "用户名已被注册"),
    REGISTER_INFO_ERROR(202, "注册信息错误"),


    BLOG_QUERY_SUCCESS(300, "查询成功"),
    BLOG_QUERY_ERROR(301, "查询失败"),

    BLOG_LIKE_SUCCESS(310, "点赞成功"),
    BLOG_LIKE_CANCLE_SUCCESS(311, "取消点赞成功"),
    BLOG_LIKE_ERROR(312, "点赞失败"),

    BLOG_ADD_SUCCESS(320,"发表微博成功"),
    BLOG_ADD_ERROR(321,"发表微博失败"),


    USER_UPDATE_SECCESS(400,"更改用户信息成功"),
    USER_UPDATE_ERROR(401,"更改用户信息失败"),
    USER_QUERY_SECCESS(410,"查询详细信息成功"),
    USER_QUERY_ERROR(411,"查询详细信息失败"),
    USER_UPLOAD_SUCCESS(420,"上传成功"),
    USER_UPLOAD_ERROR(421,"上传文件格式错误"),
    USER_UPLOAD_FAIL(422,"上传文件错误"),
    USER_UPLOAD_NULL(423,"上传的文件不能为空");


    private int state;
    private String message;

    Result(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }
    }