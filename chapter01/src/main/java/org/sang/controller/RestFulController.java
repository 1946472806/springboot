package org.sang.controller;

import org.sang.aop.service.RestFulService;
import org.sang.model.RestfulTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFulController {
    @Autowired
    RestFulService restFulService;

    @GetMapping(value = "/getauthor", produces = "application/json;charset=UTF-8")
    public Object getauthor(RestfulTable restfulTable) {
        return restFulService.getauthor(restfulTable.getAuthor());
    }
}
