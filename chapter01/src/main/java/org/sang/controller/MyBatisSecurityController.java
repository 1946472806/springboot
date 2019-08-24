package org.sang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBatisSecurityController {
    @GetMapping("/admins/url")
    public String adminsSecurity() {
        return "admins";
    }
}
