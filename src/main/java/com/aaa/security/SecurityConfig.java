package com.aaa.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    LoginSuccessHandler loginSuccessHandler;
    @Resource
    LoginErrorHandler loginErrorHandler;
    @Resource
    AuthenticationError authenticationError;
    @Resource
    AccessDenideConfig accessDenideConfig;

    /***
     * 设置请求处理方式
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 允许跨域请求
        http.cors()
                .and()
                .csrf()
                .disable()
                // 授权请求
                .authorizeRequests()
                // 请求配置
                .requestMatchers(CorsUtils::isPreFlightRequest)
                .permitAll();
        // 使用form表单登录
        http.formLogin()
                // 设置登录页面
                .loginPage("/login.html")
                // 表单提交路径
                .loginProcessingUrl("/login-check")
                .usernameParameter("uname")
                .passwordParameter("pwd")
                // 默认成功路径：登录后有目标资源，访问目标资源，没有跳转默认成功路径
                // .defaultSuccessUrl("/home.html")
                // 成功处理器
                .successHandler(loginSuccessHandler)
                .failureHandler(loginErrorHandler)
                // 失败路径
                // .failureUrl("/fail")
                // 已认证，不需要身份验证
                .permitAll()
                .and()
                // 授权请求：设置如何让处理请求
                .authorizeRequests()
                // 任意请求
                .anyRequest()
                // 认证
                // .authenticated()
                // 是否可访问逻辑，调用rbacConfig类下的hasPermission方法，返回true可访问，返回false拒绝访问
                .access("@rbacConfig.hasPermission(request,authentication)");



        // 权限验证失败错误处理
        http.exceptionHandling()
                // 处理认证：(未登录)
                .authenticationEntryPoint(authenticationError)
                // 角色权限验证失败(已经登录)
                .accessDeniedHandler(accessDenideConfig);
    }

    @Resource
    UserConfig userConfig;

    /**
     * 认证校验工作
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // 密码编码器
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        // 设置用户详细信息的获取方式
        daoAuthenticationProvider.setUserDetailsService(userConfig);
        auth.authenticationProvider(daoAuthenticationProvider);
    }
}
