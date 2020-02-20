package com.example.graduation.controller;

import com.example.graduation.entity.User;
import com.example.graduation.result.Result;
import com.example.graduation.result.ResultFactory;
import com.example.graduation.service.UserService;
import com.example.graduation.service.impl.UserServiceImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <h3>graduation</h3>
 * <p>新用户注册Controller</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 15:15
 **/

@RestController
public class RegisterController {
    @Resource
    UserService userServiceImpl;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        boolean existTheUsername = userServiceImpl.existTheUsername(user.getUsername());
        if(existTheUsername) {
            //用户名已存在
            return ResultFactory.buildFailResult("该用户名已存在，请使用另一个用户名");
        } else {
            //用户名未注册
            //保存新用户之前先加密
            SimpleHash simpleHash = new SimpleHash("MD5",user.getPassword(),user.getUsername(),1024);
            user.setPassword(simpleHash.toString());
            if(userServiceImpl.saveNewUser(user)) {
                return ResultFactory.buildSuccessResult(null, "您已成功注册，请在登录页登录");
            } else {
                return ResultFactory.buildResult(null, "服务器错误，请稍后重试", 500);
            }
        }
    }
}
