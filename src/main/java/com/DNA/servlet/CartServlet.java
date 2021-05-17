package com.DNA.servlet;

import com.DNA.bean.Book;
import com.DNA.bean.Cart;
import com.DNA.bean.CartItem;
import com.DNA.service.BookService;
import com.DNA.service.impl.BookServiceImpl;
import com.DNA.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 购车Servlet
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 15:54
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * @Description 加入购物车
     * @Return [request, response]
     * @Author 脱氧核糖
     * @Date 2021/5/17 15:57
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //新建购物车
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName", cartItem.getName());
        //重定向商品页面，从哪来回哪去
        //Referer：请求头
        //可以在请求发起时，把浏览器栏的地址发送给服务器
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * @Description 删除商品项
     * @Return [request, response]
     * @Author 脱氧核糖
     * @Date 2021/5/17 16:59
     */
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
    * @Description 清空购物车
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 17:09
    */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
    * @Description 修改商品数量
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 17:27
    */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}