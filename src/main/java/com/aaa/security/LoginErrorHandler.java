package com.aaa.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginErrorHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // 根据异常类型返回不同的错误信息
        System.out.println(e.getClass());
        // 根据请求方式判断返回结果
        // ajax请求返回信息，不是ajax请求应该返回页面
        String header = httpServletRequest.getHeader("X-Requested-With");
        String accept = httpServletRequest.getHeader("Accept");
        System.out.println("----------aaa--------------");
        boolean isAjax = false;

        if(header !=null && header.indexOf("XMLHttpRequest") !=-1){
            isAjax = true;
        }else if(accept.indexOf("application/json") != -1){
            isAjax = true;
        }
        System.out.println("isAjax"+isAjax);
        if(isAjax){
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.print("{\"code\":403,\"meaage\":登录失败,\"data\":{}}");
            writer.flush();
            writer.close();
        }else{
            httpServletResponse.sendRedirect("login.html");
        }
    }
}
