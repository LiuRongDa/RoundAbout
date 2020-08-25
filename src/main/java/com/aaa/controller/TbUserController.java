package com.aaa.controller;

import com.aaa.entity.TbUser;
import com.aaa.service.TbUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/24 18:40
 */
@RestController
@RequestMapping("tbUser")
public class TbUserController {
    @Resource
    TbUserService tbUserService;

    @RequestMapping("findByName")
    public TbUser findByName(@RequestBody TbUser tbUser){
        System.out.println("controller User"+tbUser);
        TbUser byName = tbUserService.findByName(tbUser);
        return byName;
    }

    @RequestMapping("queryAll")
    public List<TbUser> queryAll(TbUser tbUser){
        List<TbUser> tbUsers = tbUserService.queryAll(tbUser);
        return tbUsers;
    }
}
