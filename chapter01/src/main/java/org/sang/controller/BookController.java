package org.sang.controller;

import org.sang.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @GetMapping("/books")
    public ModelAndView books(){
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
        mv.addObject("books",books);
        mv.setViewName("books");
        return mv;
    }
}
