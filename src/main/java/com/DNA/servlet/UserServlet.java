package com.DNA.servlet;

import com.DNA.bean.User;
import com.DNA.service.UserService;
import com.DNA.service.impl.UserServiceImpl;
import com.DNA.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Description 用户Servlet
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 17:00
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
    * @Description 用户登录
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 15:56
    */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User login = userService.login(new User(null, username, password, null));
        if (login == null) {
            System.out.println("用户名或密码错误！");
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            //保存用户登录后的信息到Session域中
            request.getSession().setAttribute("user", login);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    /**
    * @Description 用户注销
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 15:57
    */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁Session中用户登录的信息
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }

    /**
    * @Description 用户注册
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 15:57
    */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取注册的用户名
        String username = request.getParameter("username");
        // 获取用户注册的密码
        String password = request.getParameter("password");
        // 获取用户注册的邮箱号
        String email = request.getParameter("email");
        // 获取用户注册的验证码
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());

        //获取Session中的验证码
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                userService.registerUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            } else {
                //将回显信息保存到request域中
                request.setAttribute("msg", "用户名已存在！");
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }
        } else {
            //将回显信息保存到request域中
            request.setAttribute("msg", "验证码错误！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}
