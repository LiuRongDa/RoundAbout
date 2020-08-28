package com.aaa.controller;

import com.aaa.service.TbPowerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/27 22:32
 */
@CrossOrigin
@RequestMapping("tbPower")
@RestController
public class TbPowerController {
    @Resource
    TbPowerService tbPowerService;

    @RequestMapping("queryStair")
    public String queryStair(Integer role_id){
        System.out.println(role_id);
        String queryStair = tbPowerService.queryStair(role_id);
        return queryStair;
    }
}
