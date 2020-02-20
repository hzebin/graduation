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
    //根据用户名查找用户数据
    User findByUsername(String username);
    //查找用户名是否存在
    boolean existTheUsername(String username);
    //保存新用户
    boolean saveNewUser(User user);
}
