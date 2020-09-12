package com.aaa.service;

import com.aaa.dao.TbIssueArticleMapper;
import com.aaa.dao.TbIssueGambitMapper;
import com.aaa.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.aaa.dao.TbIssueMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    TbIssueArticleMapper tbIssueArticleMapper;

    public List<TbIssueGambit> queryLike(String like){
        List<TbIssueGambit> tbIssueGambits = tbIsseGambitMapper.queryLike(like);
        return tbIssueGambits;
    }

    //查询用户回答过的问题
    public List<TbIssueArticle> queryUserIssue(Integer user_id){
        List<TbIssueArticle> tbIssueArticles = tbIssueArticleMapper.queryUserIssue(user_id);
        System.out.println("-----"+tbIssueArticles);
        return tbIssueArticles;
    }
    /*
    *查询用户问题
     */
    public List<TbIssue> userIssue(Integer user_id){
        TbIssue tbIssue = new TbIssue();
        tbIssue.setUser_id(user_id);
        List<TbIssue> tbIssues = tbIssueMapper.select(tbIssue);
        System.out.println(tbIssues);
        return tbIssues;
    }
    /**
     * 浏览次数+1
     * @return
     */
    public Integer addCount(Integer id){
        TbIssue tbIssue = new TbIssue();
        tbIssue.setIssue_id(id);
        tbIssue = tbIssueMapper.selectOne(tbIssue);
        tbIssue.setIssue_count(tbIssue.getIssue_count()+1);
        int i = tbIssueMapper.updateByPrimaryKey(tbIssue);
        return i;
    }

    /**
     * 发布问题
     * @return
     */
    public Integer insertIssue(Integer user_id,String issue_title,String issue_content,String topics){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        TbIssue tbIssue = new TbIssue();
        tbIssue.setIssue_title(issue_title);
        if(issue_content != null || issue_content != ""){
            tbIssue.setIssue_content(issue_content);
        }
        tbIssue.setUser_id(user_id);
        tbIssue.setIssue_date(dateString);
        tbIssue.setIssue_count(0);
        tbIssue.setCount(0);
        tbIssue.setPraise_count(0);

        int insert = tbIssueMapper.insert(tbIssue);

        if(topics!=null && topics!=""){
            tbIssue = tbIssueMapper.selectOne(tbIssue);
            TbIssueGambit tbIssueGambit = new TbIssueGambit();
            tbIssueGambit.setIssue_id(tbIssue.getIssue_id());
            char[] chars = topics.toCharArray();
            for (int i = 0;i<chars.length;i++){
                int a = Integer.parseInt(String.valueOf(chars[i]));
                tbIssueGambit.setGambit_id(a);
                int insert1 = tbIsseGambitMapper.insert(tbIssueGambit);
            }
        }

        return insert;
    }

    /**
     * 查询所有问题基本信息(时间倒序  分页)
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo queryAll(Integer pageNum,Integer pageSize){
        if (pageNum == null) {
            PageHelper.startPage(1,10);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbIssueGambit> tbIssueGambits = tbIsseGambitMapper.queryAll();
        PageInfo pageInfo = new PageInfo(tbIssueGambits);
        return pageInfo;
    }

    /**
     * 查询所有问题基本信息(浏览数量倒序  分页)
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo queryhot(Integer pageNum,Integer pageSize){
        if (pageNum == null) {
            PageHelper.startPage(1,10);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbIssueGambit> tbIssueGambits = tbIsseGambitMapper.queryhot();
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
        if(pageSize==null || pageSize==0) pageSize = 20;
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
