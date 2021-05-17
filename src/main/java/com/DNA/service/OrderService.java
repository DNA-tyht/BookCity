package com.DNA.service;

import com.DNA.bean.Cart;
import com.DNA.bean.Order;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 21:23
 */
public interface OrderService {

    /**
    * @Description 生成订单
    * @Return [cart, userId]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:38
    */
    public String createOrder(Cart cart, Integer userId);

    ///**
    //* @Description 发货
    //* @Return [orderId]
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:39
    //*/
    //public void showAllOrders(Integer orderId);
    //
    ///**
    //* @Description 查看订单详情
    //* @Return [orderId]
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:40
    //*/
    //public void showOrderDetail(Integer orderId);
    //
    ///**
    //* @Description 查看我的订单
    //* @Return [userId]
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:40
    //*/
    //public void showMyOrders(Integer userId);
    //
    ///**
    //* @Description 签收订单
    //* @Return [orderId]
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:41
    //*/
    //public void receiverOrder(Integer orderId);
}
