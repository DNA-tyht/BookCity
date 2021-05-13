package com.DNA.dao.impl;

import com.DNA.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/9 22:38
 */
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
    * @Description 更新一条SQL语句
    * @Return 更新失败返回-1
    * @Author 脱氧核糖
    * @Date 2021/5/9 22:50
    */
    public int update(String sql, Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        int update = -1;
        try {
            update = queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return update;
    }

    /**
    * @Description 查询返回一条javaBean的SQL语句
    * @Return [type, sql, args]
    * @Author 脱氧核糖
    * @Date 2021/5/9 22:49
    */
    public <T> Object queryForOne(Class<T> type, String sql, Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
    * @Description 查询返回多条javaBean的SQL语句
    * @Return [type, sql, args]
    * @Author 脱氧核糖
    * @Date 2021/5/9 22:53
    */
    public <T> Object queryForList(Class<T> type, String sql, Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return null;
    }

    /**
    * @Description 执行返回一行一列的SQL语句
    * @Return [sql, args]
    * @Author 脱氧核糖
    * @Date 2021/5/9 22:57
    */
    public Object queryForSingleValue(String sql, Object ... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
