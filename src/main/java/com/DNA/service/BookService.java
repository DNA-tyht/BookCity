package com.DNA.service;

import com.DNA.bean.Book;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 22:12
 */
public interface BookService {
    /**
    * @Description 添加一条图书记录
    * @Return
    * @Author 脱氧核糖
    * @Date 2021/5/14 22:18
    */
    public void addBook(Book book);
    /**
    * @Description 删除一条图书记录
    * @Return
    * @Author 脱氧核糖
    * @Date 2021/5/14 22:19
    */
    public void deleteBookById(int id);
    /**
    * @Description 更新一条图书记录
    * @Return
    * @Author 脱氧核糖
    * @Date 2021/5/14 22:20
    */
    public void updateBook(Book book);
    /**
    * @Description 根据ID查询一条图书记录
    * @Return 查询失败返回null，查询成功返回book
    * @Author 脱氧核糖
    * @Date 2021/5/14 22:21
    */
    public Book queryBookById(int id);
    /**
    * @Description 查询所有图书记录
    * @Return 查询失败返回null，查询成功返回所有book
    * @Author 脱氧核糖
    * @Date 2021/5/14 22:22
    */
    public List<Book> queryBooks();
}
