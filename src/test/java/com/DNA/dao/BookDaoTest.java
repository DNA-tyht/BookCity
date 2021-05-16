package com.DNA.dao;

import com.DNA.bean.Book;
import com.DNA.bean.Page;
import com.DNA.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 21:58
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "Java从入门到入土", "脱氧核糖", new BigDecimal(99), 100, 1, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(15);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(13, "CSS从绘制框架到改行画画", "脱氧核糖", new BigDecimal(50), 67, 100, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.deleteBookById(1));
    }

    @Test
    public void queryBook() {
        for (Book queryBook : bookDao.queryBook()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount () {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> list = bookDao.queryForPageItems(8, Page.PAGE_SIZE);
        for (Book queryBook : list) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> list = bookDao.queryForPageItemsByPrice(8, Page.PAGE_SIZE, 10, 50);
        for (Book queryBook : list) {
            System.out.println(queryBook);
        }
    }
}