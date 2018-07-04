package com.ynu.demo.service;

import com.ynu.demo.entity.UserRolePermissions;

public interface LoginService {

    UserRolePermissions findByUsername(String username);
}
