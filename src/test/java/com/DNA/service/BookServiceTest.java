package com.DNA.service;

import com.DNA.bean.Book;
import com.DNA.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/14 22:26
 */
public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(1, "Java从入门到入土", "脱氧核糖", new BigDecimal(99), 100, 1, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(16);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(14, "CSS从绘制框架到改行画画", "脱氧核糖", new BigDecimal(50), 80, 100, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}