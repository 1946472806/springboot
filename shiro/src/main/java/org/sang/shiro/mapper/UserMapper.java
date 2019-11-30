package org.sang.shiro.mapper;

import org.sang.shiro.bean.UserBean;

import java.util.List;

public interface UserMapper {
    List<UserBean> getUser();
}
