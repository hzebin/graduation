package com.example.graduation.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <h3>graduation</h3>
 * <p>User实体类</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 10:22
 **/

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增长主键
    private Integer id;

    @Column(unique = true, length = 20, nullable = false)
    private String username;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(length = 20)
    private String name;

    @Column(precision = 3)
    private Integer age;

    @Column(length = 50)
    private String email;

    @Column(length = 11)
    private String tel;
}
