package com.DNA.service.impl;

import com.DNA.bean.Book;
import com.DNA.dao.BookDao;
import com.DNA.dao.impl.BookDaoImpl;
import com.DNA.service.BookService;
import com.DNA.servlet.BaseServlet;

import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 22:23
 */
public class BookServiceImpl extends BaseServlet implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBook();
    }
}
