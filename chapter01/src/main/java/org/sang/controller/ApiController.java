package org.sang.controller;

import org.sang.model.Author;
import org.sang.model.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/test")
    public String testapi(){
        logger.trace("这是跟踪日志");
        logger.debug("这是调试日志");
        //SpringBoot默认使用的是 info级别的;root级别
        logger.info("这是自定义");
        logger.warn("这是警告日志");
        logger.error("这是错误日志");
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

