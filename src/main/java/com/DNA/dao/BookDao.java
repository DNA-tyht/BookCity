package com.DNA.dao;

import com.DNA.bean.Book;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 21:39
 */
public interface BookDao {
    /**
    * @Description 添加一条图书记录
    * @Return 更新失败返回-1，更新成功返回1
    * @Author 脱氧核糖
    * @Date 2021/5/14 21:43
    */
    public int addBook(Book book);

    /**
    * @Description 根据ID删除一条图书记录
    * @Return 更新失败返回-1，更新成功返回1
    * @Author 脱氧核糖
    * @Date 2021/5/14 21:44
    */
    public int deleteBookById(Integer id);

    /**
    * @Description 更新指定图书记录
    * @Return 更新失败返回-1，更新成功返回1
    * @Author 脱氧核糖
    * @Date 2021/5/14 21:45
    */
    public int updateBook(Book book);

    /**
    * @Description 根据ID查询一条图书记录
    * @Return 查询失败返回null，查询成功返回book
    * @Author 脱氧核糖
    * @Date 2021/5/14 21:45
    */
    public Book queryBookById(Integer id);

    /**
    * @Description 查询所有图书记录
    * @Return 查询失败返回null，查询成功返回所有book
    * @Author 脱氧核糖
    * @Date 2021/5/14 21:45
    */
    public List<Book> queryBook();

    /**
    * @Description 获取图书总数
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/15 16:19
    */
    Integer queryForPageTotalCount();

    /**
    * @Description 获取当前页数据
    * @Return [begin, pageSize]
    * @Author 脱氧核糖
    * @Date 2021/5/15 16:24
    */
    List<Book> queryForPageItems(int begin, int pageSize);

    /**
    * @Description 根据价格区间获取当前页数据数量
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/16 14:01
    */
    Integer queryForPageTotalCountByPrice(int min, int max);

    /**
    * @Description 根据价格区间获取当前页数据
    * @Return [begin, pageSize, min, max]
    * @Author 脱氧核糖
    * @Date 2021/5/16 14:03
    */
    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
