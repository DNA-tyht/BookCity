package com.DNA.bean;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 11:34
 */
public class CartTest {
    private Cart cart = new Cart();

    @Test
    public void addItem() {
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 2, new BigDecimal(86), new BigDecimal(86)));
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 1, new BigDecimal(86), new BigDecimal(86)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 2, new BigDecimal(86), new BigDecimal(86)));
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 1, new BigDecimal(86), new BigDecimal(86)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 2, new BigDecimal(86), new BigDecimal(86)));
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 1, new BigDecimal(86), new BigDecimal(86)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 2, new BigDecimal(86), new BigDecimal(86)));
        cart.addItem(new CartItem(1, "黑客攻防：从入门到入狱", 1, new BigDecimal(86), new BigDecimal(86)));
        cart.updateCount(1, 4);
        System.out.println(cart);
    }
}