package com.aaa.service;

import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/24 14:10
 */
@Service
public class TbUserService {
    @Resource
    TbUserMapper tbUserMapper;

    public TbUser findByName(String userName){
        TbUser name = tbUserMapper.findName(userName);
        return name;
    }
}
