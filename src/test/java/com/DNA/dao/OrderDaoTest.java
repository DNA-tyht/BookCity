package com.DNA.dao;

import com.DNA.bean.Order;
import com.DNA.dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 22:00
 */
public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567890", new Date(), new BigDecimal(100), 0, 1));
    }
}