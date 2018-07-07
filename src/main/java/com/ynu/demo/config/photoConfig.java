package com.ynu.demo.config;

import org.springframework.beans.factory.annotation.Value;
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

    public static String ImageResources;
    @Value("${ImageResources}")
    public void setImageResources(String imageResources){
        ImageResources = imageResources;
    }

    public static String NewsImageResources;
    @Value("${NewsImageResources}")
    public void setNewsImageResources(String newsImageResources){
        NewsImageResources = newsImageResources;
    }

    public static String HomepageImageResources;
    @Value("${HomepageImageResources}")
    public void setHomepageImageResources(String homepageImageResources){
        HomepageImageResources = homepageImageResources;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/PersonImage/**").addResourceLocations(ImageResources);
        registry.addResourceHandler("/NewsImage/**").addResourceLocations(NewsImageResources);
        registry.addResourceHandler("/NewsImage/HomepageImage/**").addResourceLocations(HomepageImageResources);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize("10MB");
        //设置总上传数据总大小
        factory.setMaxRequestSize("30MB");
        return factory.createMultipartConfig();
    }
}
