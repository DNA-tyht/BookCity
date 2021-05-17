package com.DNA.dao;

import com.DNA.bean.OrderItem;
import com.DNA.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 22:06
 */
public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null, "Java从入门到入土", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
    }
}