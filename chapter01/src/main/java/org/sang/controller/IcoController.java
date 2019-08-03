package org.sang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IcoController {
    @RequestMapping("/index")
    public String ico(){
        return "index";
    }
}


