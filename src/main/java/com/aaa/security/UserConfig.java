package com.aaa.security;

import com.aaa.controller.TbUserController;
import com.aaa.entity.TbUser;
import com.aaa.service.TbUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserConfig implements UserDetailsService {
    @Resource
    TbUserController tbUserController;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        TbUser tbUser=new TbUser();
        tbUser.setUserName(username);
        tbUser = tbUserController.findByName(tbUser);
        System.out.println("tbUser"+tbUser);
        //查询用户权限信息
        List<GrantedAuthority> grantedAuthorities1 = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,add,select");
        List<GrantedAuthority> grantedAuthorities2 = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_TEST,select");

        if(tbUser == null){
            throw new UsernameNotFoundException("用户没有找到");
        }
        if(tbUser.getUserName().equals("zs")){
            tbUser.setAuthorityList(grantedAuthorities1);
        }else{
            tbUser.setAuthorityList(grantedAuthorities2);
        }
        return tbUser;
    }
}
