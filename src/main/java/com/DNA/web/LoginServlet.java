package com.DNA.web;
/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/12 22:57
 */

import com.DNA.pojo.User;
import com.DNA.service.UserService;
import com.DNA.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User login = userService.login(new User(null, username, password, null));
        if (login == null) {
            System.out.println("用户名或密码错误！");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }
}
