package com.aaa.service;

import com.aaa.dao.TbStaffMapper;
import com.aaa.entity.TbStaff;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/25 11:13
 */
@Service
public class TbStaffService {
    @Resource
    TbStaffMapper tbStaffMapper;

    /**
     * 查询名字  安全框架
     * @param tbStaff
     * @return
     */
    public TbStaff findByName(TbStaff tbStaff){
        TbStaff staff = tbStaffMapper.selectOne(tbStaff);
        return staff;
    }

    /**
     * 关联role 查询全部
     * @return
     */
    public List<TbStaff> queryStallAndRole(){
        List<TbStaff> tbStaffs = tbStaffMapper.queryStallAndRole(null);
        return tbStaffs;
    }

    /**
     * 添加员工信息
     * @param tbStaff
     * @return
     */
    public Boolean add(TbStaff tbStaff){
        Boolean add = tbStaffMapper.add(tbStaff);
        return add;
    }

    /**
     * 修改员工信息
     * @param tbStaff
     * @return
     */
    public Boolean update(TbStaff tbStaff){
        Boolean update = tbStaffMapper.update(tbStaff);
        return update;
    }

    /**
     *
     * 修改状态
     * @param staff_id
     * @return
     */
    public Boolean upState(Integer staff_id){
        Boolean state = tbStaffMapper.upState(staff_id);
        return state;
    }

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<TbStaff> selePage(Integer pageNum,Integer pageSize,String staff_name){
        if(pageNum==null || pageNum==0){
            PageHelper.startPage(1,5);
        }else if(pageSize==null || pageSize==0){
            PageHelper.startPage(pageNum,5);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbStaff> tbStaffs = tbStaffMapper.queryStallAndRole(staff_name);
        PageInfo<TbStaff> pageInfo=new PageInfo<>(tbStaffs);
        return pageInfo;
    }

    /**
     * 修改个人信息
     * @param staff_id
     * @param staff_name
     * @param staff_idcard
     * @param staff_phone
     * @return
     */
    public Boolean upInfo(Integer staff_id,String staff_name,String staff_idcard,String staff_phone){
        Boolean aBoolean = tbStaffMapper.upInfo(staff_id, staff_name, staff_idcard, staff_phone);
        return aBoolean;
    }


    /**
     * LRD 后台 校验密码是否一致
     * @param staff_id
     * @return
     */
    public Boolean oldPwd(Integer staff_id){
        TbStaff staff = tbStaffMapper.selectByPrimaryKey(staff_id);
        if(staff.getPassword().equals(staff.getStaff_pwd()))return true;
        return false;
    }

    /**
     * 修改密码
     * @param staff_pwd
     * @param staff_id
     * @return
     */
    public Boolean upPwd(String staff_pwd,Integer staff_id){
        //密码加密
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encode = bCrypt.encode(staff_pwd);
        Boolean aBoolean = tbStaffMapper.upPwd(encode, staff_id);
        return aBoolean;
    }
}
