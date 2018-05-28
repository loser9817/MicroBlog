package com.loser.service;

import com.loser.dao.Userdao;
import com.loser.entity.User;
import com.loser.enums.Result;
import com.loser.enums.ResultStates;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UserService {

    @Autowired
    private Userdao userdao;

    /**
     * 执行登录
     *
     * @param usn 前端传回的用户名username
     * @param psw 前端传回的密码password
     * @return 返回统一的json格式
     */
    public ResultStates<Result> doLogin(String usn, String psw) {
        String password = userdao.queryPasswordByName(usn);
        if (password == null) {
            return new ResultStates<Result>(Result.LOGIN_USER_UNDEFINED);
        } else if (!password.equals(psw)) {
            return new ResultStates<Result>(Result.LOGIN_PSW_ERRPR);
        }
        return new ResultStates<Result>(Result.LOGIN_SUCCESS);
    }

    /**
     * 执行注册
     *
     * @param user 传入User对象将对象插入数据库
     * @return 返回统一json格式
     */
    public ResultStates<Result> doRegister(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || password == null || username.trim() == "" || password.trim() == "") {
            return new ResultStates<Result>(Result.REGISTER_INFO_ERROR);
        }
        String psw = userdao.queryPasswordByName(username);
        if (psw != null) {
            return new ResultStates<Result>(Result.REGISTER_USER_EXISTS);
        }
        userdao.addUser(user);
        return new ResultStates<Result>(Result.REGISTER_SUCCESS);
    }

    /**
     * 根据id查找user详细信息
     *
     * @param id user_id
     * @return 返回查找的user
     */
    public ResultStates<User> selectUserInfoById(int id) {

        User user = userdao.queryUseInforById(id);
        return new ResultStates<User>(Result.USER_QUERY_SECCESS, user);
    }

    /**
     * 更新user详细信息
     *
     * @param user 传入user对象update user表
     * @return 返回表中json格式
     */
    public ResultStates<User> updateUserInfo(User user) {

        if (userdao.setUserInfoById(user) == 1) {
            //更新用户信息成功
            ResultStates<User> userResultStates = selectUserInfoById(user.getId());
            return new ResultStates<User>(Result.USER_UPDATE_SECCESS, userResultStates.getData());
        }
        return new ResultStates<User>(Result.USER_UPDATE_ERROR);
    }

    /**
     * 更换用户头像
     * 开启事务
     */
    @Transactional
    public ResultStates<String> updateUserHead(MultipartFile file, int userId) {

        //判断文件是否为空
        if (!file.isEmpty()) {
            //判断是否为图片格式
            String filename = file.getOriginalFilename();
            if (filename.endsWith(".jpg")
                    || filename.endsWith(".jpeg")
//                    || filename.endsWith(".png")
                    ) {

                try {
                    String head = "E:/ideaProject/MicroBlog/src/main/resources/head/" + userId + ".jpg";
                    //保存文件到本地
                    FileUtils.writeByteArrayToFile(new File(head), file.getBytes());
                    //上传成功
                    return new ResultStates<String>(Result.USER_UPLOAD_SUCCESS, head);
                } catch (IOException e) {
                    e.printStackTrace();
                    return new ResultStates<String>(Result.USER_UPLOAD_FAIL);
                }
            } else {
                //格式错误
                return new ResultStates<String>(Result.USER_UPLOAD_ERROR);
            }
        }
        //file==null
        return new ResultStates<String>(Result.USER_UPLOAD_NULL);
    }

    /**
     * 修改个人简介
     */
    public ResultStates<String> updateIntro(int id, String intro) {

        if (userdao.setUserIntroById(id, intro) == 1) {
            return new ResultStates<String>(Result.USER_UPDATE_SECCESS);
        } else {
            return new ResultStates<String>(Result.USER_UPDATE_ERROR);
        }
    }
}
