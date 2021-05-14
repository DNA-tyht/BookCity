package com.DNA.dao.impl;

import com.DNA.dao.UserDao;
import com.DNA.bean.User;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/10 8:24
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ?";
        return (User) queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernamePassword(String username, String password) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? and password = ?";
        return (User) queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) values(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }


}
