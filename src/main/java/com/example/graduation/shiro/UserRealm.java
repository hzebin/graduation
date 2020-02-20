package com.example.graduation.shiro;

import com.example.graduation.entity.User;
import com.example.graduation.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

import javax.annotation.Resource;

/**
 * <h3>graduation</h3>
 * <p>自定义Realm</p>
 *
 * @author : 黄泽彬
 * @date : 2020-02-20 10:29
 **/

public class UserRealm extends AuthenticatingRealm {

    @Resource
    UserService userServiceImpl;

    /**
     * 验证从数据库获取的密码，与用户输入的密码（经过了后台的MD5加密）
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //subject.login之后会到这里验证密码

        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        //获取用户输入的用户名usernamePasswordToken.getUsername()
        //根据username去数据库获取User数据
        User user = userServiceImpl.findByUsername(usernamePasswordToken.getUsername());

        //参数：User类的user对象, 从数据库中获取到的password, 当前realm的名字
       return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
