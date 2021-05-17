package com.DNA.dao;

import com.DNA.bean.OrderItem;


/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 21:45
 */
public interface OrderItemDao {

    /**
    * @Description 保存订单项
    * @Return [orderItem]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:46
    */
    public int saveOrderItem(OrderItem orderItem);

    ///**
    //* @Description 根据订单号查询订单明细
    //* @Return [orderId]
    //* @Author 脱氧核糖
    //* @Date 2021/5/17 21:48
    //*/
    //public List<OrderItem> queryOrderItemsByOrderId(Integer orderId);
}
