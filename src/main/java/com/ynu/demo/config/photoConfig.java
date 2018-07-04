package com.ynu.demo.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

/**
 * @Author: IceSource and QW
 * @Description:
 * @Date: Created in 17:13 2018/7/4 WebMvcConfigurerAdapter
 */
@Configuration
public class photoConfig implements WebMvcConfigurer {

    /**
     * 在配置文件中配置的文件保存路径
     */
//    @Value("${banner.image.location}")
//    private String location = "./demo/src/resources/photo";

    private static String localUrl = "file:C:\\Users\\10049\\Desktop\\item\\demo\\src\\main\\resources\\photo\\";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //上传的图片在D盘下的OTA目录下，访问路径如：http://localhost:8081/OTA/d3cf0281-bb7f-40e0-ab77-406db95ccf2c.jpg
        registry.addResourceHandler("/image/**").addResourceLocations(localUrl);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("10MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("15MB");
        return factory.createMultipartConfig();
    }
}
