package com.ynu.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 14:55 2018/6/30
 */
@Entity
@Data
public class UserRolePermissions {
    @Id
    private String id;

    private String username;

    private String password;

    private String role;

    private String permissions;

}
