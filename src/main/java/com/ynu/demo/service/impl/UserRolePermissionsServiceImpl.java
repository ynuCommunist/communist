package com.ynu.demo.service.impl;

import com.ynu.demo.Enum.ResultEnum;
import com.ynu.demo.entity.UserRolePermissions;
import com.ynu.demo.exception.MyException;
import com.ynu.demo.repository.UserRolePermissionsRepository;
import com.ynu.demo.service.UserRolePermissionsService;
import com.ynu.demo.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:36 2018/7/3
 */
@Service
public class UserRolePermissionsServiceImpl implements UserRolePermissionsService {

    @Autowired
    private UserRolePermissionsRepository userRolePermissionsRepository;


    @Override
    public Page<UserRolePermissions> getList(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<UserRolePermissions> page = userRolePermissionsRepository.findAll(pageable);
        return page;
    }

    @Override
    public void updateUser(UserRolePermissions userRolePermissions) {
        if(userRolePermissionsRepository.findById(userRolePermissions.getId()).isPresent()){
            userRolePermissions.setPassword(MD5Util.MD5(userRolePermissions.getPassword(),userRolePermissions.getId()));
            userRolePermissionsRepository.save(userRolePermissions);
        }else {
            throw new MyException(ResultEnum.ID_NOT_CHANGE);
        }
    }

    @Override
    public void addUser(UserRolePermissions userRolePermissions) {
        if(userRolePermissionsRepository.findById(userRolePermissions.getId()).isPresent()){
            throw new RuntimeException("id已存在");
        }
        userRolePermissions.setId(String.valueOf((int)System.currentTimeMillis()) + String.valueOf((Math.random()*9+1)*100));
        userRolePermissions.setPassword(MD5Util.MD5(userRolePermissions.getPassword(),userRolePermissions.getId()));
        userRolePermissionsRepository.save(userRolePermissions);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRolePermissionsRepository.findById(id).isPresent()){
            throw new MyException(ResultEnum.ID_NOT_EXIST);
        }
        if(userRolePermissionsRepository.findById(id).get().getRole().equals("admin")){
            throw new MyException(ResultEnum.ADMIN_ERROR);
        }
        userRolePermissionsRepository.deleteById(id);
    }

    @Override
    public Page<UserRolePermissions> findAllByRole(Integer pageNum, Integer pageSize, String finding) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<UserRolePermissions> page = userRolePermissionsRepository.findAllByRole(finding,pageable);
        if(!page.hasContent()){
            throw new MyException(ResultEnum.ROLE_NOT_EXIST);
        }
        return page;
    }


}
