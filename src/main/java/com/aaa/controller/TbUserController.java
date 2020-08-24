package com.aaa.controller;

import com.aaa.service.TbUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


}
