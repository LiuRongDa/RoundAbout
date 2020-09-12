package com.aaa.security;

import com.aaa.controller.back.TbstaffController;
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
        TbStaff tbStaff=new TbStaff();
        tbStaff.setStaff_number(username);
        tbStaff = tbstaffController.findByName(tbStaff);
        return tbStaff;
    }
}
