package com.aaa.service;

import com.aaa.dao.TbArticleMapper;
import com.aaa.entity.TbArticle;
import com.aaa.dao.TbArticleGambitMapper;
import com.aaa.entity.TbArticleGambit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/28 13:55
 * @author Artls
 * @date 2020/8/28 10:44
 */
@Service
public class TbArticleService {
    @Resource
    TbArticleMapper tbArticleMapper;

    @Resource
    TbArticleGambitMapper tbArticleGambitMapper;

    /**
     * 查询所有文章基本信息(分页)
     *
     * @return
     */
    public PageInfo query(Integer pageNum,Integer pageSize){
        if (pageNum == null) {
            PageHelper.startPage(1,2);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbArticleGambit> tbArticleGambits = tbArticleGambitMapper.queryAll();
        PageInfo pageInfo = new PageInfo(tbArticleGambits);
        return pageInfo;
    }

    /**
     * 查询单个文章
     * @param article_id
     * @return
     */
    public List<TbArticleGambit> queryById(@Param("article_id") Integer article_id){
        List<TbArticleGambit> tbArticleGambits = tbArticleGambitMapper.queryById(article_id);
        return tbArticleGambits;
    }

}