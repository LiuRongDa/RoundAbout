package com.aaa.service;

import com.aaa.dao.*;
import com.aaa.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    TbIssueArticleMapper tbIssueArticleMapper;

    @Resource
    TbCommentMapper tbCommentMapper;

    @Resource
    TbUserMapper tbUserMapper;

    // wh 查询用户的文章
    public List<TbArticle> queryUser(Integer id){
        TbArticle tbArticle = new TbArticle();
        tbArticle.setUser_id(id);
        List<TbArticle> select = tbArticleMapper.select(tbArticle);
        System.out.println(select);
        return select;
    }

    /**
     * 查询所有文章的基本信息(文章，用户  时间倒序,分页)
     *
     * @return
     */
    public PageInfo queryAll(Integer pageNum,Integer pageSize){
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
     *查询所有文章的基本信息(文章，用户  浏览数倒序 分页)
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo queryhot(Integer pageNum,Integer pageSize){
        if (pageNum == null) {
            PageHelper.startPage(1,2);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbArticleGambit> queryhot = tbArticleGambitMapper.queryhot();
        PageInfo pageInfo = new PageInfo(queryhot);
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

    /**
     * 查询指定问题下的 评论 回复,[回复]
     */
    public List<TbArticle> queryByIdIss(Integer issue_id){
        TbIssueArticle tbIssueArticle = new TbIssueArticle();
        tbIssueArticle.setIssue_id(issue_id);
        List<TbIssueArticle> tbIssueArticles = tbIssueArticleMapper.select(tbIssueArticle);

        TbArticle tbArticle = new TbArticle();

        List<TbArticle> art = new ArrayList<TbArticle>();
        for(TbIssueArticle ia : tbIssueArticles){
            tbArticle.setArticle_id(ia.getArticle_id());
            TbArticle tbArticle1 = tbArticleMapper.selectOne(tbArticle);

            art.add(tbArticle1);
        }

        TbUser tbUser = new TbUser();
        TbComment tbComment = new TbComment();
        for(TbArticle a : art){
            tbUser.setUser_id(a.getUser_id());
            TbUser tbUser1 = tbUserMapper.selectByPrimaryKey(tbUser);
            tbComment.setArticle_id(a.getArticle_id());
            List<TbComment> select = tbCommentMapper.select(tbComment);
            a.setTbUser(tbUser1);
            a.setTbComments(select);
        }
        return art;
    }

}