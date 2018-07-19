package com.chao.dao;

import com.chao.po.User;

import java.util.List;

public interface UserDao {
    User getUserByUsername(String username);

    List<String> queryRolesByUsername(String username);

    List<String> queryRolesByRole_name(String role_name);
}
