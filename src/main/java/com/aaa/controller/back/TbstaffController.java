package com.aaa.controller.back;

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
    public PageInfo<TbStaff> add(String tbStaff){
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
        if(add) return selePage(null,null,null);
        return null;
    }

    /**
     * 修改员工信息
     * @param
     * @return
     */
    @RequestMapping("update")
    public PageInfo<TbStaff> update(String staff_name,String staff_number,String staff_pwd,Integer staff_sex,String staff_idcard,String staff_phone,Integer role_id,Integer staff_id){
        Boolean update = tbStaffService.update(staff_name, staff_number, staff_pwd, staff_sex, staff_idcard, staff_phone, role_id, staff_id);
        System.out.println(staff_name);
        if (update)return selePage(null,null,null);
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
    public PageInfo<TbStaff> selePage(Integer pageNum,Integer pageSize,String staff_name){
        PageInfo<TbStaff> pageInfo = tbStaffService.selePage(pageNum, pageSize,staff_name);
        return pageInfo;
    }

    @RequestMapping("upInfo")
    public Boolean upInfo(Integer staff_id,String staff_name,String staff_idcard,String staff_phone){
        Boolean aBoolean = tbStaffService.upInfo(staff_id, staff_name, staff_idcard, staff_phone);
        return aBoolean;
    }

    /**
     * 校验密码是否一致
     * @return
     */
    @RequestMapping("oldPwd")
    public Boolean oldPwd(String staff_pwd,String oldPwd){
        Boolean aBoolean = tbStaffService.oldPwd(staff_pwd, oldPwd);
        if(aBoolean)return true;
        return false;
    }

    /**
     * 修改密码
     * @param staff_pwd
     * @param staff_id
     * @return
     */
    @RequestMapping("upPwd")
    public Boolean upPwd(String staff_pwd,Integer staff_id){
        Boolean aBoolean = tbStaffService.upPwd(staff_pwd, staff_id);
        if(aBoolean)return true;
        return false;
    }

    @RequestMapping("queryAll")
    public List<TbStaff> queryAll(){
        List<TbStaff> tbStaffs = tbStaffService.queryAll();
        return tbStaffs;
    }
}
