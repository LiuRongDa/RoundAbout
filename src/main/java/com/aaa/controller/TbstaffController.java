package com.aaa.controller;

import com.aaa.entity.TbStaff;
import com.aaa.service.TbStaffService;
import com.aaa.utils.JacksonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/25 11:15
 */
@RequestMapping("tbStaff")
@RestController
@CrossOrigin
public class TbstaffController {
    @Resource
    TbStaffService tbStaffService;

    /**
     * 查询名字  安全框架
     * @param tbStaff
     * @return
     */
    @RequestMapping("findByName")
    public TbStaff findByName(TbStaff tbStaff){
        TbStaff byName = tbStaffService.findByName(tbStaff);
        return byName;
    }

    /**
     * 关联role 查询所有
     * @return
     */
    @RequestMapping("queryStallAndRole")
    public List<TbStaff> queryStallAndRole(){
        List<TbStaff> tbStaffs = tbStaffService.queryStallAndRole();
        return tbStaffs;
    }

    /**
     * 添加员工信息
     * @param tbStaff
     * @return
     */
    @RequestMapping("add")
    public List<TbStaff> add(String tbStaff){
        TbStaff tbStaff1=new TbStaff();
        try {
            tbStaff1 = JacksonUtils.json2pojo(tbStaff, TbStaff.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //密码加密
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        tbStaff1.setStaff_pwd(bCrypt.encode(tbStaff1.getPassword()));
        Boolean add = tbStaffService.add(tbStaff1);
        if(add) return queryStallAndRole();
        return null;
    }

    /**
     * 修改员工信息
     * @param tbStaff
     * @return
     */
    @RequestMapping("update")
    public List<TbStaff> update(String tbStaff){
        System.out.println("-----------------------"+tbStaff);
        TbStaff tbStaff1=new TbStaff();
        try {
            tbStaff1 = JacksonUtils.json2pojo(tbStaff, TbStaff.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Boolean update = tbStaffService.update(tbStaff1);
        if(update) return queryStallAndRole();
        return null;
    }

    /**
     * 修改状态
     * @param staff_id
     * @return
     */
    @RequestMapping("upState")
    public List<TbStaff> upState(Integer staff_id){
        Boolean aBoolean = tbStaffService.upState(staff_id);
        if(aBoolean) return queryStallAndRole();
        return null;
    }

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("selePage")
    public PageInfo selePage(Integer pageNum,Integer pageSize,String staff_name){
        PageInfo<TbStaff> pageInfo = tbStaffService.selePage(pageNum, pageSize,staff_name);
        return pageInfo;
    }

    /**
     * 模糊查询
     * @param staff_name
     * @return
     */
   /* @RequestMapping("seleSeche")
    public List<TbStaff> seleSeche(String staff_name){
        System.out.println("--------------------"+staff_name);
        List<TbStaff> tbStaffs = tbStaffService.seleSeche(staff_name);
        return tbStaffs;
    }*/
}
