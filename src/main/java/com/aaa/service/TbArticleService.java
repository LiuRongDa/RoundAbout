package com.aaa.service;

import com.aaa.dao.*;
import com.aaa.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Resource
    TbIssueMapper tbIssueMapper;

    /**
     *
     * @param user_id
     * @param article_title
     * @param article_content
     * @param topics
     * @return
     */
    public Integer insertArticle(Integer user_id,String article_title,String article_content,String topics){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        TbArticle tbArticle = new TbArticle();
        tbArticle.setUser_id(user_id);
        tbArticle.setArticle_title(article_title);
        tbArticle.setArticle_content(article_content);
        tbArticle.setArticle_state(0);
        tbArticle.setArticle_count(0);
        tbArticle.setCount(0);
        tbArticle.setPraise_count(0);
        tbArticle.setArticle_date(dateString);
        int insert = tbArticleMapper.insert(tbArticle);

        if(topics!=null && topics!=""){
            tbArticle = tbArticleMapper.selectOne(tbArticle);
            TbArticleGambit tbArticleGambit = new TbArticleGambit();
            tbArticleGambit.setArticle_id(tbArticle.getArticle_id());
            char[] chars = topics.toCharArray();
            for (int i = 0;i<chars.length;i++){
                int a = Integer.parseInt(String.valueOf(chars[i]));
                tbArticleGambit.setGambit_id(a);
                int insert1 = tbArticleGambitMapper.insert(tbArticleGambit);
            }
        }
        return insert;
    }

    /**
     * 添加回答
     * @return
     */
    public Integer addArticle(Integer issue_id,Integer user_id,String article_content){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        TbArticle tbArticle = new TbArticle();
        tbArticle.setUser_id(user_id);
        tbArticle.setArticle_content(article_content);
        tbArticle.setArticle_count(0);
        tbArticle.setCount(0);
        tbArticle.setPraise_count(0);
        tbArticle.setArticle_state(0);
        tbArticle.setArticle_date(dateString);

        int insert = tbArticleMapper.insert(tbArticle);
        if(insert > 0){
            TbArticle tbArticle1 = tbArticleMapper.selectOne(tbArticle);
            Integer article_id = tbArticle1.getArticle_id();
            TbIssueArticle tbIssueArticle = new TbIssueArticle();
            tbIssueArticle.setIssue_id(issue_id);
            tbIssueArticle.setArticle_id(article_id);
            int insert1 = tbIssueArticleMapper.insert(tbIssueArticle);

            TbIssue tbIssue = tbIssueMapper.selectByPrimaryKey(issue_id);
            int i = tbIssue.getCount() + 1;
            tbIssue.setCount(i);
            int up = tbIssueMapper.updateByPrimaryKey(tbIssue);
        }
        return insert;
    }

    @Resource
    TbReportService tbReportService;

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
     * 查询指定问题下的 回答
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

    /**
     * LRD 后台 分页+模糊查询
     * @param pageNum
     * @param pageSize
     * @param article_title
     * @param article_content
     * @return
     */
    public PageInfo<TbArticle> selePage(Integer pageNum, Integer pageSize,String article_title,String article_content,String article_date){
        if(pageNum==null || pageNum==0) pageNum = 1;
        if(pageSize==null || pageSize==0) pageSize = 5;
        PageHelper.startPage(pageNum,pageSize);
        List<TbArticle> tbArticles =tbArticleMapper.selePage(article_title,article_content,article_date);
        PageInfo<TbArticle> pageInfo=new PageInfo<>(tbArticles);
        return pageInfo;
    }

    /**
     * LRD 后台 查看详情
     * @param article_id
     * @return
     */
    public TbArticle seleOne(Integer article_id){
        TbArticle tbArticle=new TbArticle();
        tbArticle.setArticle_id(article_id);
        TbArticle selectOne = tbArticleMapper.selectOne(tbArticle);
        return selectOne;
    }

    /**
     * LRD 后台 删除文章
     * @param article_id
     */
    public void del(Integer article_id){
        tbReportService.delArticle(article_id);
    }
}