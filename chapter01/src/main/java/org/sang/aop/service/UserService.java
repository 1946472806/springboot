package org.sang.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserById(Integer id){
        System.out.println("get..."+id.toString());
        return "user"+id.toString();
    }

    public void deleteUserById(Integer id){
        Integer a = 1/ 0;
        System.out.println("delete..."+id.toString());
    }
}