package com.ynu.demo.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("2MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }
}
