package org.sang.controller;

import org.sang.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {
    @GetMapping("/test")
    public String testapi(){
        return "This is my first springboot.";
    }

//    @Autowired
//    private Book book;
    @GetMapping("/book")
    public Book book(){
        Book book = new Book();
//        return book.toString();
        book.setAuthor("廖雪峰");
        book.setName("Spring Boot + vue全栈开发");
        return book;
    }
}

