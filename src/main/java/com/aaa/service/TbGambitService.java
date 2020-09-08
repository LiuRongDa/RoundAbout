package com.aaa.service;

import com.aaa.dao.TbArticleGambitMapper;
import com.aaa.dao.TbGambitMapper;
import com.aaa.dao.TbIssueArticleMapper;
import com.aaa.dao.TbIssueGambitMapper;
import com.aaa.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/31 10:13
 */
@Service
public class TbGambitService {
    @Resource
    TbGambitMapper tbGambitMapper;

    @Resource
    TbArticleGambitMapper tbArticleGambitMapper;

    @Resource
    TbIssueGambitMapper tbIssueGambitMapper;

    /**
     * 查找所有的话题
     * @return
     */
    public List<TbGambit> query(){
        List<TbGambit> tbGambits = tbGambitMapper.selectAll();
        return tbGambits;
    }

    /**
     * 查询指定问题的话题
     * @param issue_id
     * @return
     */
    public List<TbGambit> queryByIdIss(Integer issue_id){
        TbIssueGambit tbIssueGambit = new TbIssueGambit();
        tbIssueGambit.setIssue_id(issue_id);

        List<TbIssueGambit> tbIssueGambits = tbIssueGambitMapper.select(tbIssueGambit);
        List<TbGambit> tbGambits = new ArrayList<>();

        for(int i = 0;i<tbIssueGambits.size();i++){
            TbGambit tbGambit1 = tbGambitMapper.selectByPrimaryKey(tbIssueGambits.get(i).getGambit_id());
            tbGambits.add(i,tbGambit1);
        }
        return tbGambits;
    }

    /**
     *查询指定文章的话题
     */
    public List<TbGambit> queryById(Integer article_id){
        TbArticleGambit tbArticleGambit = new TbArticleGambit();
        tbArticleGambit.setArticle_id(article_id);
        List<TbArticleGambit> tbArticleGambits = tbArticleGambitMapper.select(tbArticleGambit);
        List<TbGambit> tbGambits = new ArrayList<>();
        for(int i = 0;i<tbArticleGambits.size();i++){
            TbGambit tbGambit1 = tbGambitMapper.selectByPrimaryKey(tbArticleGambits.get(i).getGambit_id());
            /*System.out.println(i+"--->"+tbGambit1);*/
            tbGambits.add(i,tbGambit1);
        }
        return tbGambits;
    }

    /**
     * LRD 后台 查询全部
     * @return
     */
    public List<TbGambit> queryAll(Integer gambit_id,String gambit_name){
        List<TbGambit> tbGambits = tbGambitMapper.queryAll(gambit_id,null);
        return tbGambits;
    }

    /**
     * LRD 后台  添加话题
     * @param tbGambit
     * @return
     */
    public Boolean add(TbGambit tbGambit){
        int insert = tbGambitMapper.insert(tbGambit);
        if(insert==1)return true;
        return false;
    }

    /**
     * LRD 后台  修改话题
     * @param tbGambit
     * @return
     */
    public Boolean update(TbGambit tbGambit){
        int update = tbGambitMapper.updateByPrimaryKey(tbGambit);
        if(update==1)return true;
        return false;
    }

    /**
     * LRD 后台 分页+模糊查询
     * @param pageNum
     * @param pageSize
     * @param gambit_id
     * @param gambit_name
     * @return
     */
    public PageInfo<TbGambit> selePage(Integer pageNum, Integer pageSize, Integer gambit_id,String gambit_name){
        if(pageNum==null || pageNum==0) pageNum = 1;
        if(pageSize==null || pageSize==0) pageSize = 5;
        PageHelper.startPage(pageNum,pageSize);
        List<TbGambit> tbGambits =tbGambitMapper.queryAll(null,gambit_name);
        PageInfo<TbGambit> pageInfo=new PageInfo<>(tbGambits);
        return pageInfo;
    }

    /**
     * LRD 后台 删除话题
     * @param gambit_id
     * @return
     */
    public Boolean del(Integer gambit_id){
        List<TbGambit> tbGambits = queryAll(gambit_id, null);
        int i=0;
        for (TbGambit t:tbGambits) {
            if(t.getTbArticle().size()==0){
                i=tbGambitMapper.deleteByPrimaryKey(gambit_id);
            }
        }
        if(i==1)return true;
        return false;
    }
}
