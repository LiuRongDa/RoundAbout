package com.aaa.service;

import com.aaa.dao.TbIssueGambitMapper;
import com.aaa.dao.TbIssueMapper;
import com.aaa.entity.TbGambit;
import com.aaa.entity.TbIssue;
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

    @Resource
    TbIssueMapper tbIssueMapper;

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

    /**
     * 后台 分页+模糊查询
     * @param pageNum
     * @param pageSize
     * @param issue_title
     * @param issue_content
     * @return
     */
    public PageInfo<TbIssue> selePage(Integer pageNum, Integer pageSize, String issue_title,String issue_content){
        if(pageNum==null || pageNum==0) pageNum = 1;
        if(pageSize==null || pageSize==0) pageSize = 2;
        PageHelper.startPage(pageNum,pageSize);
        List<TbIssue> tbIssues =tbIssueMapper.selePage(issue_title,issue_content);
        PageInfo<TbIssue> pageInfo=new PageInfo<>(tbIssues);
        return pageInfo;
    }

    /**
     * LRD 后台 添加修改
     * @param tbIssue
     * @return
     */
    public Boolean save(TbIssue tbIssue){
        if(tbIssue.getIssue_id()==null){
            Boolean add = tbIssueMapper.add(tbIssue);
            if(add)return true;
            return false;
        }else{
            Boolean update = tbIssueMapper.update(tbIssue);
            if(update)return true;
            return false;
        }
    }
}
