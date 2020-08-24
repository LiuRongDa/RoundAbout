package com.aaa.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/8 12:20
 */
@Component
public class LoginErrorHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        System.out.println(e.getClass());

        String header = httpServletRequest.getHeader("X-Requested-With");
        //根据请求头判断是否是异步请求
        if(header!=null && header.indexOf("XMLHttpRequest")!=-1){
            //要返回JSON
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
