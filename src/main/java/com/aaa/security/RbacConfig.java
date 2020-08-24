package com.aaa.security;

import com.aaa.entity.TbUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/7 21:53
 */
@Component("rbacConfig")
public class RbacConfig {
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            TbUser tbUser=(TbUser) principal;
            String requestURI = request.getRequestURI();
            System.out.println(requestURI);
            if(requestURI.length()>30){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
}
