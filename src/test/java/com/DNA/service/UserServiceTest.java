package com.DNA.service;

import com.DNA.bean.User;
import com.DNA.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/10 9:12
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "DNA", "123456", "DNA@qq.com"));
    }

    @Test
    public void login() {
        if (userService.login(new User(null, "admin", "123456", "admin@qq.com")) == null) {
            System.out.println("用户名或密码错误，登录失败！");
        } else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin") == true) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }
}