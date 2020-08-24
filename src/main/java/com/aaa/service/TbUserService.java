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

    /**
     * 查询用户名
     * @param tbUser
     * @return
     */
    public TbUser findByName(TbUser tbUser){
        System.out.println(tbUser);
        TbUser selectOne = tbUserMapper.selectOne(tbUser);
        return selectOne;
    }


}
