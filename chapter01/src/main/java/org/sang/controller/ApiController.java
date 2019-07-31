package org.sang.controller;

import org.sang.Author;
import org.sang.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


@RestController
public class ApiController {
    @GetMapping("/test")
    public String testapi(){
        return "This is my first springboot.";
    }

    //注意@Autowired声明的类和Book book = new Book()的区别,一个是自动化装箱绑定，一个是单独赋值才有值
    @Autowired
    private Book book;
    @GetMapping("/book")
    public Book book(){
//        Book book = new Book();
//        return book.toString();
        book.setAuthor("廖雪峰");
        book.setName("Spring Boot + vue全栈开发");
        return book;
    }

    @GetMapping("/global")
    public void getstar(Model model){
        Map<String,Object> map = model.asMap();
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            Object value = map.get(key);
            System.out.println(key+">>>>>>>>"+value);
        }
    }

    @GetMapping("/bookauthor")
    public String bookauthor(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author){
        return book.toString() + ">>>>>>" + author.toString();
    }
}

