package org.sang.controller;

import org.sang.model.Book;
import org.sang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> books = new ArrayList<>();
        Book b = new Book();
        b.setId(2);
        b.setAuthor("廖雪峰");
        b.setName("Spring Boot + vue全栈开发");
        Book c = new Book();
        c.setId(3);
        c.setAuthor("sunk");
        c.setName("Python高级算法运用");
        books.add(b);
        books.add(c);
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }
    /*
    bookService
     */
    @Autowired
    BookService bookService;

    @GetMapping("/bookOps")
    public void bookOps() {
        Book b1 = new Book();
        b1.setName("西厢记");
        b1.setAuthor("王实甫");
        b1.setPrice((float) 20);
        int i = bookService.addBook(b1);
        System.out.println("addBook>>>" + i);

        Book b2 = new Book();
        b2.setId(11);
        b2.setName("朝花夕拾");
        b2.setAuthor("鲁迅");
        int updateBook = bookService.updateBook(b2);
        System.out.println("updateBook>>>" + updateBook);

        Book b3 = bookService.getBookById(8);
        System.out.println("getBookById>>>" + b3);

        int deleteBookById = bookService.deleteBookById(8);
        System.out.println("deleteBookById>>>" + deleteBookById);

        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("getAllBooks>>>" + allBooks);

    }
}
