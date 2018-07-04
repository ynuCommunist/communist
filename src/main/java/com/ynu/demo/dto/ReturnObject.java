package com.ynu.demo.dto;

import lombok.Data;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 21:30 2018/7/3
 */
@Data
public class ReturnObject {

    private String username;

    private String[] roles;

    private String[] permissions;

    public ReturnObject(String username, String[] roles, String[] permissions) {
        this.username = username;
        this.roles = roles;
        this.permissions = permissions;
    }
}
