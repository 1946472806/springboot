package org.sang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitTestController {
    @GetMapping("/unitTest")
    public String testapi(String name) {
        return "胡歌";
    }
}
