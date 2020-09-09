package com.aaa.service;

import com.aaa.dao.TbIssueUserMapper;
import com.aaa.entity.TbIssueUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/9 3:16
 */
@Service
public class TbIssueUserService {
    @Resource
    TbIssueUserMapper tbIssueUserMapper;

    /**
     * LRD 后台 添加问题用户桥梁表信息
     * @param tbIssueUser
     * @return
     */
    public Boolean add(TbIssueUser tbIssueUser){
        int insert = tbIssueUserMapper.insert(tbIssueUser);
        if(insert==1)return true;
        return false;
    }
}
