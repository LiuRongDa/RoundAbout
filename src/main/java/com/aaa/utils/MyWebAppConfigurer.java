package com.aaa.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WH
 * @date 2020/9/1 12:05
 *  配置上传到本地 图片的映射路径
 */
@Configuration
@Component
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Value("${upload.profile}")
    private  String profile;//绝对路径
    @Value("${upload.relativePath}")
    private  String relativePath;//相对路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(relativePath+"**").addResourceLocations("file:"+profile);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
