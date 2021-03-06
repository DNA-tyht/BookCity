package com.DNA.dao.impl;

import com.DNA.bean.Book;
import com.DNA.dao.BookDao;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 21:43
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`, `author`, `price`, `sales`, `stock`, `img_path`) values(?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?, `author`=?, `price`=?, `sales`=?, `stock`=?, `img_path`=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` from t_book where id =?";
        return (Book) queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBook() {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` from t_book";
        return (List<Book>) queryForList(Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number) queryForSingleValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` from t_book limit ?, ?";
        return (List<Book>) queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number = (Number) queryForSingleValue(sql, min, max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` from t_book where price between ? and ? order by price limit ?, ?";
        return (List<Book>) queryForList(Book.class, sql, min, max, begin, pageSize);
    }
}
