package com.DNA.service;

import com.DNA.bean.Cart;
import com.DNA.bean.CartItem;
import com.DNA.service.impl.OrderServiceImpl;
import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 22:30
 */
public class OrderServiceTest {
    Cart cart = new Cart();
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 2, new BigDecimal(86), new BigDecimal(86)));
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 1, new BigDecimal(86), new BigDecimal(86)));
        System.out.println(orderService.createOrder(cart, 1));
    }
}