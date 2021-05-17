package com.DNA.servlet;

import com.DNA.bean.Book;
import com.DNA.bean.Page;
import com.DNA.service.BookService;
import com.DNA.service.impl.BookServiceImpl;
import com.DNA.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Description 后台图书管理Servlet
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 22:38
 */
public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    /**
    * @Description 增加图书
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 15:55
    */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        //请求的转发
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
        //表单重复提交
        //浏览器会记录最后一次请求的全部信息
        //用户刷新时会发起浏览器记录的最后一次请求
        //request.getRequestDispatcher("/manager/bookServlet?action=page").forward(request, response);
    }

    /**
    * @Description 删除图书
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 15:55
    */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        String id = request.getParameter("id");
        bookService.deleteBookById(Integer.parseInt(id));
        //重定向图书管理界面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    /**
    * @Description 修改图书
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/17 15:55
    */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.updateBook(book);
        //重定向图书管理界面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    /**
    * @Description 获取request域对象
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/15 14:04
    */
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.queryBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    /**
    * @Description 后台分页
    * @Return [request, response]
    * @Author 脱氧核糖
    * @Date 2021/5/15 16:05
    */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
