package com.aaa.security;

import com.aaa.controller.TbstaffController;
import com.aaa.entity.TbStaff;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserConfig implements UserDetailsService {
    @Resource
    TbstaffController tbstaffController;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        TbStaff tbStaff=new TbStaff();
        tbStaff.setStaff_number(username);
        tbStaff = tbstaffController.findByName(tbStaff);
        System.out.println("tbUser"+tbStaff);
        //查询用户权限信息
        List<GrantedAuthority> grantedAuthorities1 = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,add,select");
        List<GrantedAuthority> grantedAuthorities2 = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_TEST,select");

        if(tbStaff == null){
            throw new UsernameNotFoundException("用户没有找到");
        }
        if(tbStaff.getStaff_number().equals("zs")){
            tbStaff.setAuthorityList(grantedAuthorities1);
        }else{
            tbStaff.setAuthorityList(grantedAuthorities2);
        }
        return tbStaff;
    }
}
