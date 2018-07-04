package com.ynu.demo.service;

import com.ynu.demo.entity.UserRolePermissions;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 16:35 2018/7/3
 */
public interface UserRolePermissionsService {

    /*获取所有用户信息*/
    Page<UserRolePermissions> getList(Integer pageNum, Integer pageSize);

    /*修改用户信息*/
    void updateUser(UserRolePermissions userRolePermissions);

    /*添加用户信息*/
    void addUser(UserRolePermissions userRolePermissions);

    /*删除用户信息*/
    void deleteUser(String id);

    /*根据角色查找所有用户*/
    Page<UserRolePermissions> findAllByRole(Integer pageNum, Integer pageSize, String finding);


}
