package com.aaa.service;

import com.aaa.dao.TbIssueGambitMapper;
import com.aaa.entity.TbIssueGambit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Artls
 * @date 2020/8/28 9:25
 */
@Service
public class TbIssueService {
    @Resource
    TbIssueGambitMapper tbIsseGambitMapper;

    /**
     * 查询所有问题基本信息(分页)
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo queryAll(Integer pageNum,Integer pageSize){
        if (pageNum == null) {
            PageHelper.startPage(1,2);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbIssueGambit> tbIssueGambits = tbIsseGambitMapper.queryAll();
        PageInfo pageInfo = new PageInfo(tbIssueGambits);
        return pageInfo;
    }

    /**
     * 查询单个问题
     * @return
     */
    public List<TbIssueGambit> queryById(Integer issue_id){
        List<TbIssueGambit> tbIssueGambits = tbIsseGambitMapper.queryById(issue_id);
        return tbIssueGambits;
    }
}
