package org.sang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JspController {
    @GetMapping("/jsp")
    public String jspTest() {
        return "my";
    }
}
