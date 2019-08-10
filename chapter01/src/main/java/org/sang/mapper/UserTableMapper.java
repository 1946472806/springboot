package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.model.RoleTableSecurity;
import org.sang.model.UserTableSecurity;

import java.util.List;

@Mapper
public interface UserTableMapper {
    UserTableSecurity loadUserByUsername(String username);
    List<RoleTableSecurity> getUserRolesByUid(Integer id);
}
