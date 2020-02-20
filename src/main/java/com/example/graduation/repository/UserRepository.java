package com.example.graduation.repository;

import com.example.graduation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h3>graduation</h3>
 * <p>User，与数据库交互的接口</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 10:50
 **/

public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 根据用户名查找User表中的user数据
     * @param username
     * @return User
     */
    User findByUsername(String username);

    /**
     * count计数，查找username
     * @param username
     * @return
     */
    long countByUsername(String username);
}
