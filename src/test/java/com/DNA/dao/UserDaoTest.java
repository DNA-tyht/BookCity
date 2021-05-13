package com.DNA.dao;

import com.DNA.dao.impl.UserDaoImpl;
import com.DNA.pojo.User;
import org.junit.Test;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/10 9:12
 */
public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernamePassword() {
        if (userDao.queryUserByUsernamePassword("admin", "123456") == null) {
            System.out.println("用户名或密码错误，登录失败！");
        } else {
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        User user = new User(null, "脱氧核糖", "123456", "tyht@qq.com");
        if (userDao.saveUser(user) != -1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}