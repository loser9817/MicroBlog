package com.loser.service;

import com.loser.dao.Userdao;
import com.loser.entity.User;
import com.loser.enums.LoginStateEnum;
import com.loser.enums.RegisterStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private Userdao userdao;

    public LoginStateEnum doLogin(String usn, String psw) {
        String password = userdao.queryPasswordByName(usn);
        if (password == null) {
            return LoginStateEnum.UNDEFINED;
        } else if (!password.equals(psw)) {
            return LoginStateEnum.ERROR;
        }
        return LoginStateEnum.SUCCESS;
    }

    public RegisterStateEnum doRegister(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null && password == null) {
            return RegisterStateEnum.ERROR;
        }
        String psw = userdao.queryPasswordByName(username);
        if (psw!=null){
            return RegisterStateEnum.EXISTS;
        }
        userdao.addUser(user);
        return RegisterStateEnum.SUCCESS;
    }
}
