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
public class UserServiceImpl implements com.example.graduation.service.UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existTheUsername(String username) {
        System.out.println("需要查询的用户名为："+ username);
        long count = userRepository.countByUsername(username);
        System.out.println("count=" + count);
        if (count == 0) {
            System.out.println("该用户名还未注册");
            return false;
        } else {
            System.out.println("该用户名已经注册");
            return true;
        }
    }

    @Override
    public boolean saveNewUser(User user) {
        User save = userRepository.save(user);
        if(save != null) {
            return true;
        } else {
            return false;
        }
    }
}
