package org.sang.service;

import org.sang.mapper.UserTableMapper;
import org.sang.model.UserTableSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyBatisSecurityRegService implements UserDetailsService {
    @Autowired
    UserTableMapper userTableMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTableSecurity userTableSecurity = userTableMapper.loadUserByUsername(username);
        if (userTableSecurity == null){
            throw new UsernameNotFoundException("账户不存在");
        }
        userTableSecurity.setRoles(userTableMapper.getUserRolesByUid(userTableSecurity.getId()));
        return userTableSecurity;
    }
}
