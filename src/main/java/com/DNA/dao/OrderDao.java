package com.DNA.dao;

import com.DNA.bean.Order;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 21:41
 */
public interface OrderDao {
    /**
    * @Description 保存订单
    * @Return [order]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:42
    */
    public int saveOrder(Order order);

    ///**
    //* @Description 查询全部订单
    //* @Return []
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:42
    //*/
    //public List<Order> queryOrders();
    //
    ///**
    //* @Description 修改订单状态
    //* @Return [orderId, status]
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:43
    //*/
    //public int changOrderStatus(Integer orderId, Integer status);
    //
    ///**
    //* @Description 根据用户编号查询订单信息
    //* @Return [userId]
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:44
    //*/
    //public List<Order> queryOrdersByUserId(Integer userId);
}
