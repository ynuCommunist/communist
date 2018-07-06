package com.ynu.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 21:06 2018/7/4
 */
//@Configuration
public class imageConfig extends WebMvcConfigurerAdapter {

    private static String localUrl = "file:C:\\Users\\10049\\Desktop\\item\\demo\\src\\main\\resources\\photo\\";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        registry.addResourceHandler("/image/**").addResourceLocations(localUrl);
    }
}
