package com.loser.web;

import com.loser.entity.User;
import com.loser.enums.Result;
import com.loser.enums.ResultStates;
import com.loser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/MicroBlog")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST)
    public ResultStates<Result> doLogin(@RequestParam("username") String username,
                                        @RequestParam("password") String password) {

        return userService.doLogin(username, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultStates<Result> Regisert(@RequestParam(value = "username") String username,
                                         @RequestParam(value = "password") String password
    ) {

        User user = new User(username, password);

        return userService.doRegister(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResultStates<User> queryUserInfo(@PathVariable("id") int id){

        return userService.selectUserInfoById(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResultStates<User> editUser(@RequestBody User user){

        return userService.updateUserInfo(user);
    }

    @RequestMapping(value = "/user/{userId}/head",
            method = RequestMethod.POST
//            produces = "multipart/form-data"
    )
    public ResultStates<String> uploadHead(@PathVariable("userId") int userId, @RequestParam("flie") MultipartFile file){

        return userService.updateUserHead(file, userId);
    }
}
