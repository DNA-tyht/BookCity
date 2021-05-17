package com.DNA.servlet;

import com.DNA.bean.Cart;
import com.DNA.bean.User;
import com.DNA.service.OrderService;
import com.DNA.service.impl.OrderServiceImpl;
import com.DNA.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 订单Servlet
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 21:18
 */
public class OrderServlet extends BaseServlet{
    OrderService orderService = new OrderServiceImpl();

    /**
    * @Description 生成订单
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:22
    */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser == null) {
            request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);
        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
    * @Description 查看所有订单
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:22
    */
    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
    * @Description 发货
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:22
    */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
    * @Description 查看订单详情
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:22
    */
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
    * @Description 查看我的订单
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:23
    */
    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
    * @Description 签收订单
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 21:23
    */
    protected void receiverOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
