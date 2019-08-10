package org.sang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/admin/url")
    public String adminSecurity(){
        return "admin";
    }

    @GetMapping("/user/url")
    public String userSecurity(){
        return "user";
    }

    @GetMapping("/db/url")
    public String dbSecurity(){
        return "db";
    }

    @GetMapping("url")
    public String Security(){
        return "spring security~";
    }
}
