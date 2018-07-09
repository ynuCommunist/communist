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

    private String lng;

    private String lat;

    public arrayCity(String city, Integer comunitCount) {
        this.city = city;
        this.comunitCount = comunitCount;
    }

    public arrayCity(String city, Integer comunitCount, String lng, String lat) {
        this.city = city;
        this.comunitCount = comunitCount;
        this.lng = lng;
        this.lat = lat;
    }
}
