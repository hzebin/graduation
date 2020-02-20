package com.example.graduation.controller;

import com.example.graduation.entity.User;
import com.example.graduation.result.Result;
import com.example.graduation.result.ResultFactory;
import com.example.graduation.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <h3>graduation</h3>
 * <p>登录Controller</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 10:38
 **/

@RestController
public class LoginController {

    @PostMapping("/login")  //登录
    public Result login(@RequestBody User user) {
        //algorithmName代表进行加密的算法名称、
        //source代表需要加密的元数据，如密码、
        //salt代表盐，需要加进一起加密的数据、
        //hashIterations代表hash迭代次数。
        // 将密码进行非可逆加密，数据库保存的是这个加密后的值->simpleHash
        SimpleHash simpleHash = new SimpleHash("MD5",user.getPassword(),user.getUsername(),1024);
        System.out.println("获取用户输入的用户名和密码之后，进行加密，这个值是保存在数据库里的：password=" + simpleHash.toString());
        //UsernamePasswordToken 是用来存储用户和密码的
        //private String username;  //用户
        //private char[] password;  //密码
        //private boolean rememberMe; //记住密码
        //private String host;  //主机
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), simpleHash.toString());

        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录,跳转到UserRealm进行密码验证
            subject.login(token);

            User resultUser = (User) subject.getPrincipal();

            HashMap<Object, Object> data = new HashMap<>();
            data.put("id",resultUser.getId());
            data.put("name",resultUser.getName());
            data.put("email", resultUser.getEmail());
            //生成token返回给客户端
            String t = JWTUtil.sign(resultUser);
            System.out.println("token=" + t);
            data.put("token",JWTUtil.sign(resultUser));
            return ResultFactory.buildSuccessResult(data,"登录成功");
            //登录成功
        } catch (AuthenticationException e) {
            return ResultFactory.buildFailResult("登陆失败");
            //登录失败
        }
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("测试，访问的路径为/test");
        return "test";
    }

}
