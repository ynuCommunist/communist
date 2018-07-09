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

    public static String PersonImageResources;
    @Value("${PersonImageResources}")
    public void setPersonImageResources(String personImageResources){
        PersonImageResources = personImageResources;
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

        registry.addResourceHandler("/PersonImage/*").addResourceLocations(PersonImageResources);
        registry.addResourceHandler("/NewsImage/HomepageImage/*").addResourceLocations(HomepageImageResources);
        registry.addResourceHandler("/NewsImage/*").addResourceLocations(NewsImageResources);

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
