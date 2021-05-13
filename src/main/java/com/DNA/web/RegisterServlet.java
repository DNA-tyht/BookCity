package com.DNA.web;

import com.DNA.pojo.User;
import com.DNA.service.UserService;
import com.DNA.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 用户注册的Servlet
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/10 9:29
 */
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取注册的用户名
        String username = request.getParameter("username");
        // 获取用户注册的密码
        String password = request.getParameter("password");
        // 获取用户注册的邮箱号
        String email = request.getParameter("email");
        // 获取用户注册的验证码
        String code = request.getParameter("code");

        if ("abc".equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                userService.registerUser(new User(null, username, password, email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            } else {
                System.out.println("用户名已存在，注册失败！");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }
        } else {
            // 验证码错误，返回注册页面。并且提示错误
            System.out.println("验证码错误！");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}
