package com.ynu.demo.dto;

import lombok.Data;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 9:19 2018/7/3
 */
@Data
public class arrayCity {

    private String city;

    private Integer comunitCount;

    public arrayCity(String city, Integer comunitCount) {
        this.city = city;
        this.comunitCount = comunitCount;
    }
}
