package com.aaa.security;

import com.aaa.entity.TbStaff;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("rbacConfig")
public class Rbacconfig {
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            TbStaff tbStaff = (TbStaff) principal;
            if(tbStaff.getStaff_name().equals("zs")){
                System.out.println("url"+request.getRequestURI());
                return true;
            }
        }else{
            System.out.println("meiyren");
        }
        return false;
    };
}
