package com.DNA.service.impl;

import com.DNA.bean.*;
import com.DNA.dao.BookDao;
import com.DNA.dao.OrderDao;
import com.DNA.dao.OrderItemDao;
import com.DNA.dao.impl.BookDaoImpl;
import com.DNA.dao.impl.OrderDaoImpl;
import com.DNA.dao.impl.OrderItemDaoImpl;
import com.DNA.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 22:21
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + userId + "";
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        //获取购物车中的每一个商品项，保存为每一个订单项
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }
}
