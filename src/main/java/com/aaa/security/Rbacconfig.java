package com.aaa.security;

import com.aaa.dao.TbStaffMapper;
import com.aaa.entity.TbStaff;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("rbacConfig")
public class Rbacconfig {
    @Resource
    TbStaffMapper tbStaffMapper;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication){
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails){
            TbStaff tbStaff = (TbStaff) principal;
            List<TbStaff> tbStaffList = tbStaffMapper.seleNum();
            for (TbStaff staff :tbStaffList) {
                if(tbStaff.getStaff_number().equals(staff.getStaff_number())){
                    System.out.println("url"+request.getRequestURI());
                    return true;
                }
            }
            /*if(tbStaff.getStaff_number().equals("zs") || tbStaff.getStaff_number().equals("ls")){
                System.out.println("url"+request.getRequestURI());
                return true;
            }*/
        }else{
            System.out.println("meiyren");
        }
        return false;
    };
}
