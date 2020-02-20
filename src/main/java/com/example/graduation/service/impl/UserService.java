package com.example.graduation.service.impl;

import com.example.graduation.entity.User;
import com.example.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <h3>graduation</h3>
 * <p>UserService实现类</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 10:48
 **/

@Service
public class UserService implements com.example.graduation.service.UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
