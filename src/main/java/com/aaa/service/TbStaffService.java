package com.aaa.service;

import com.aaa.dao.TbStaffMapper;
import com.aaa.entity.TbStaff;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
     * 模糊查询
     * @param staff_name
     * @return
     */
   /* public List<TbStaff> seleSeche(String staff_name){
        List<TbStaff> tbStaffs = tbStaffMapper.queryStallAndRole(staff_name);
        return tbStaffs;
    }*/
}
