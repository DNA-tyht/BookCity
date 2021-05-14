package com.DNA.service.impl;

import com.DNA.dao.UserDao;
import com.DNA.dao.impl.UserDaoImpl;
import com.DNA.bean.User;
import com.DNA.service.UserService;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/10 9:02
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernamePassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return true;
        } else {
            return false;
        }
    }
}
