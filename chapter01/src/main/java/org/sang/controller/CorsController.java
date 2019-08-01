package org.sang.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cors")
public class CorsController {
    @PostMapping("/")
    @CrossOrigin(value = "https://127.0.0.1:8081",maxAge = 1800,allowedHeaders = "*")
    public String addcros(String name){
        return "receive:"+name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "https://127.0.0.1:8081",maxAge = 1800,allowedHeaders = "*")
    public String deletecros(@PathVariable("id") Long id){
        return String.valueOf(id);
    }
}
