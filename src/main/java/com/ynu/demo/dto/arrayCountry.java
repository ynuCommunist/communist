package com.ynu.demo.dto;

import lombok.Data;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 12:53 2018/7/9
 */
@Data
public class arrayCountry {
    private String country;

    private Integer comunitCount;

    public arrayCountry(String country, Integer comunitCount) {
        this.country = country;
        this.comunitCount = comunitCount;
    }
}
