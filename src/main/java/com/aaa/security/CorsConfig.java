package com.aaa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/*
* 配置跨域请求
* */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        System.out.println("CorsFilter");
        //跨域请求配置
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //
        corsConfiguration.setAllowCredentials(true);
        //允许的请求域名
        corsConfiguration.addAllowedOrigin("*");
        //允许的请求头
        corsConfiguration.addAllowedHeader("*");
        //允许的请求方式
        corsConfiguration.addAllowedMethod("POST");
        // 基于请求路径的跨域配置
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // 注册跨域配置
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
