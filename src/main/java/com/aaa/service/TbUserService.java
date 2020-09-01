package com.aaa.service;

import com.aaa.dao.TbEducationMapper;
import com.aaa.dao.TbProfessionMapper;
import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
     *  LRD 后台 关联 trade 表 分页 +模糊搜索
     * @return
     */
    public PageInfo<TbUser> selePage(Integer pageNum,Integer pageSize,String user_name){
        if(pageNum==null || pageNum==0){
            PageHelper.startPage(1,2);
        }else if(pageSize==null || pageSize==0){
            PageHelper.startPage(pageNum,2);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbUser> tbUsers = tbUserMapper.userAndTradeQueryAll(user_name);
        PageInfo<TbUser> pageInfo=new PageInfo<>(tbUsers);
        return pageInfo;
    }


    /**
     *  LRD  后台添加
     * @param tbUser
     * @return
     */
    public Boolean add(TbUser tbUser){
        //加密
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String pwd = bCrypt.encode(tbUser.getUser_pwd());
        tbUser.setUser_pwd(pwd);
        Boolean add = tbUserMapper.add(tbUser);
        return add;
    }

    /**
     * LRD 后台 修改状态
     * @param user_state
     * @param user_id
     * @return
     */
    public Boolean upState(Integer user_state,Integer user_id){
        Boolean aBoolean = tbUserMapper.upState(user_state, user_id);
        return aBoolean;
    }

    /**
     * LRD 后台 查询全部用户
     * @return
     */
    public List<TbUser> queryAll(){
        return tbUserMapper.selectAll();
    }
}
