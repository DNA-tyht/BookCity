package com.DNA.service;

import com.DNA.pojo.User;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/10 8:57
 */
public interface UserService {
    /**
    * @Description 注册用户
    * @Return [user]
    * @Author 脱氧核糖
    * @Date 2021/5/10 9:00
    */
    public void registerUser(User user);

    /**
    * @Description 登录
    * @Return [user]
    * @Author 脱氧核糖
    * @Date 2021/5/10 9:00
    */
    public User login(User user);

    /**
    * @Description 检查用户名是否可用
    * @Return [username]
    * @Author 脱氧核糖
    * @Date 2021/5/10 9:01
    */
    public boolean existsUsername(String username);
}
