package com.DNA.dao;

import com.DNA.bean.User;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/10 8:16
 */
public interface UserDao {
    /**
    * @Description 根据用户名查询用户信息
    * @Return 查询失败返回null，查询成功返回user
    * @Author 脱氧核糖
    * @Date 2021/5/10 8:20
    */
    public User queryUserByUsername(String username);

    /**
    * @Description 根据用户名密码查询用户信息
    * @Return 查询失败返回null，查询成功返回user
    * @Author 脱氧核糖
    * @Date 2021/5/10 8:23
    */
    public User queryUserByUsernamePassword(String username, String password);

    /**
    * @Description 保存一条user信息
    * @Return 更新失败返回-1，更新成功返回1
    * @Author 脱氧核糖
    * @Date 2021/5/10 8:32
    */
    public int saveUser(User user);
}
