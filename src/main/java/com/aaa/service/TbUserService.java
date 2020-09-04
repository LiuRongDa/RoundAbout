package com.aaa.service;

import com.aaa.dao.TbEducationMapper;
import com.aaa.dao.TbProfessionMapper;
import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbUser;
import com.aaa.security.BCryptPasswordEncoderRun;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/24 14:10
 */
@Service
public class TbUserService {
    @Resource
    TbUserMapper tbUserMapper;

    @Resource
    TbProfessionMapper tbProfessionMapper;

    @Resource
    TbEducationMapper tbEducationMapper;

    @Resource
    BCryptPasswordEncoderRun bCryptPasswordEncoderRun;

    //注册
    public int toRegister(String email,String pwd){
        TbUser tbUser = new TbUser();
        tbUser.setUser_email(email);
        tbUser.setUser_name("zh"+Math.random()*10000);
        tbUser.setUser_state(0);
        tbUser.setUser_joindate(new Date());
        tbUser.setUser_pwd(bCryptPasswordEncoderRun.passwordEncoder().encode(pwd));
        int insert = tbUserMapper.insert(tbUser);
        return insert;
    }
    /**
     * wh
     * 登录
     */
    public TbUser toLogin(String email,String pwd){
        TbUser tbUser = new TbUser();
        if (email.contains("@"))
            tbUser.setUser_email(email);
        else
            tbUser.setUser_phone(email);
        TbUser tbUser1 = tbUserMapper.selectOne(tbUser);
        boolean matches = bCryptPasswordEncoderRun.passwordEncoder().matches(pwd, tbUser1.getUser_pwd());
        if (matches)
            return tbUser1;
        else
            return null;
    }
    //查询邮箱是否存在
    public TbUser byemail(String email){
        TbUser tbUser = new TbUser();
        tbUser.setUser_email(email);
        return tbUserMapper.selectOne(tbUser);
    }
    //设置密码
    public boolean setpwd(int id, String pwd){
        TbUser tbUser = new TbUser();
        tbUser.setUser_id(id);
        tbUser.setUser_pwd(bCryptPasswordEncoderRun.passwordEncoder().encode(pwd));
        int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
        if (i>0)
            return true;
        else
            return false;
    }

    /**
     * 查询用户
     */
/*    public TbUser queryProfession(){
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(1);
        //查询该用户的职业经历
        TbProfession tbProfession = new TbProfession();
        tbProfession.setUser_id(tbUser.getUser_id());
        List<TbProfession> tbProfessions = tbProfessionMapper.select(tbProfession);
        //查询该用户的教育经历
        TbEducation tbEducation = new TbEducation();
        tbEducation.setUser_id(tbUser.getUser_id());
        List<TbEducation> tbEducations = tbEducationMapper.select(tbEducation);


        tbUser.setTbProfessionList(tbProfessions);
        tbUser.setTbEducations(tbEducations);
        return tbUser;
    }*/

    /**
     * 关联 trade 表 分页 +模糊搜索
     * @return
     */
    public PageInfo<TbUser> selePage(Integer pageNum,Integer pageSize){
        if(pageNum==null || pageNum==0){
            PageHelper.startPage(1,2);
        }else if(pageSize==null || pageSize==0){
            PageHelper.startPage(pageNum,2);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbUser> tbUsers = tbUserMapper.userAndTradeQueryAll();
        System.out.println(tbUsers);
        PageInfo<TbUser> pageInfo=new PageInfo<>(tbUsers);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
