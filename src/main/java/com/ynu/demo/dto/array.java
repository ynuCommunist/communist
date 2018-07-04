package com.ynu.demo.dto;

import lombok.Data;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 9:19 2018/7/3
 */
@Data
public class array {

    private String city;

    private Integer comunitCount;

    public array(String city, Integer comunitCount) {
        this.city = city;
        this.comunitCount = comunitCount;
    }
}
