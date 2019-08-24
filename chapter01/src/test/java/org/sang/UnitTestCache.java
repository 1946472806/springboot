package org.sang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sang.model.Book;
import org.sang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitTestCache {
    @Autowired
    BookService bookService;

    @Test
    public void cacheTest() {
        bookService.getBookById(10);
        bookService.getBookById(10);
        bookService.deleteBookById(10);
        Book book = bookService.getBookById(11);
        System.out.println("book:" + book);
        Book book1 = new Book();
        book1.setName("琅琊榜");
        book1.setAuthor("胡歌");
        book1.setId(11);
        bookService.addBook(book1);

        Book book2 = bookService.getBookById(11);
        System.out.println("book2:" + book2);
    }
}
