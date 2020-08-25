package com.aaa.service;

import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        TbUser selectOne = tbUserMapper.selectOne(tbUser);
        return selectOne;
    }

    /**
     * 查询全部
     * @param tbUser
     * @return
     */
    public List<TbUser> queryAll(TbUser tbUser){
        List<TbUser> select = tbUserMapper.select(tbUser);
        return select;
    }
}
