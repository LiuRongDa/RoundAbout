package com.aaa.controller;

import com.aaa.entity.TbStaff;
import com.aaa.service.TbStaffService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @RequestMapping("findByName")
    public TbStaff findByName(TbStaff tbStaff){
        TbStaff byName = tbStaffService.findByName(tbStaff);
        return byName;
    }


}
