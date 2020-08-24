package com.aaa.security;

import com.aaa.entity.TbUser;
import com.aaa.service.TbUserService;
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
    TbUserService tbUserService;

    /**
     * 根据用户名加载用户信息
     * @param s 表单提交的用户名
     * @return 用户详细信息
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        /*SimpleGrantedAuthority role_admin = new SimpleGrantedAuthority("ROLE_ADMIN");
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        authorityList.add(role_admin);*/
        TbUser tbUser = tbUserService.findByName(s);
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
        return (UserDetails) tbUser;
    }

}
