package com.aaa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsUtils;

import javax.annotation.Resource;

// 将当前类作为配置类使用
@Configuration
// 启用security
@EnableWebSecurity
//启用全局方法注解配置
@EnableGlobalMethodSecurity(securedEnabled = true)
/*https://blog.csdn.net/jiachunchun/article/details/90235412*/

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    UserConfig userConfig;
    @Resource
    LoginSuccessHandler loginSuccessHandler;
    @Resource
    LoginErrorHandler loginErrorHandler;
    /***
     * 设置请求处理方式
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    // 授权请求
                .authorizeRequests()
                //除了这个路径其他的都拦截
                .antMatchers("/Reception/**").permitAll()
                // 请求配置
                .requestMatchers(CorsUtils::isPreFlightRequest)
                .permitAll();
        // 使用form表单登录
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login-check")
                .usernameParameter("name")
                .passwordParameter("pwd")
                //成功的处理器
                .successHandler(loginSuccessHandler)
                .failureHandler(loginErrorHandler)
                //.defaultSuccessUrl("/home.html")
                //.failureUrl("/fail")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                //.authenticated()
                //是否可访问逻辑  Rbacconfig类下的hasPermission方法
                .access("@rbacConfig.hasPermission(request,authentication)")
                .and()
                //允许跨域
                .cors()
                .and()
                .csrf()
                .disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userConfig);
        auth.authenticationProvider(daoAuthenticationProvider);
    }
}
