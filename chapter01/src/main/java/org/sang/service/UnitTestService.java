package org.sang.service;

import org.springframework.stereotype.Service;

@Service
public class UnitTestService {
    public String unitTest(String name){
        return "Test~" + name + "~";
    }
}
