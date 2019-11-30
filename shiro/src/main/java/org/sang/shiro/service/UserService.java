package org.sang.shiro.service;

import org.sang.shiro.bean.UserBean;
import org.sang.shiro.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<UserBean> getUser(){
        return userMapper.getUser();
    }
}
