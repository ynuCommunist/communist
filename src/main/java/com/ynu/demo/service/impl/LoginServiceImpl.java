package com.ynu.demo.service.impl;

import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.repository.LoginRepository;
import com.ynu.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 15:07 2018/6/30
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserRolePermissions findByUsername(String name) {
        return loginRepository.findByUsername(name);
    }
}
