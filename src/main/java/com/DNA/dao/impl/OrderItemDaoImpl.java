package com.DNA.dao.impl;

import com.DNA.bean.OrderItem;
import com.DNA.dao.OrderItemDao;


/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 21:51
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`, `count`, `price`, `total_price`, `order_id`) values(?, ?, ?, ?, ?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    //@Override
    //public List<OrderItem> queryOrderItemsByOrderId(Integer orderId) {
    //    return null;
    //}
}
