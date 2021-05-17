package com.DNA.dao.impl;

import com.DNA.bean.Order;
import com.DNA.dao.OrderDao;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 21:51
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`, `create_time`, `price`, `status`, `user_id`) values(?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
