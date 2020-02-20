package com.example.graduation.service;

import com.example.graduation.entity.User;

/**
 * <h3>graduation</h3>
 * <p>UserService接口</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 10:48
 **/

public interface UserService {
    User findByUsername(String username);  //根据用户名查找用户数据
}
