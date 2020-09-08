package com.aaa.service;

import com.aaa.dao.*;
import com.aaa.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/9/8 11:30
 */
@Service
public class TbPraiseService {
    @Resource
    TbPraiseMapper tbPraiseMapper;

    @Resource
    TbArticleMapper tbArticleMapper;

    @Resource
    TbCommentMapper tbCommentMapper;

    @Resource
    TbReplyMapper tbReplyMapper;

    @Resource
    TbIssueMapper tbIssueMapper;

    /**
     * 点赞文章
     */
    public Integer praiseArticle(Integer article_id,Integer user_id){
        TbPraise tbPraise = new TbPraise();
        tbPraise.setArticle_id(article_id);
        tbPraise.setUser_id(user_id);
        List<TbPraise> select = tbPraiseMapper.select(tbPraise);

        if(select.size() != 0){
            int delete = tbPraiseMapper.delete(tbPraise);
            TbArticle tbArticle = tbArticleMapper.selectByPrimaryKey(article_id);
            tbArticle.setPraise_count(tbArticle.getPraise_count()-1);
            tbArticleMapper.updateByPrimaryKey(tbArticle);
            return 0;
        }else{
            int insert = tbPraiseMapper.insert(tbPraise);
            TbArticle tbArticle = tbArticleMapper.selectByPrimaryKey(article_id);
            tbArticle.setPraise_count(tbArticle.getPraise_count()+1);
            tbArticleMapper.updateByPrimaryKey(tbArticle);
            return 1;
        }
    }

    /**
     * 点赞评论
     * @param comment_id
     * @param user_id
     * @return
     */
    public Integer praiseComment(Integer comment_id,Integer user_id){
        TbPraise tbPraise = new TbPraise();
        tbPraise.setComment_id(comment_id);
        tbPraise.setUser_id(user_id);
        List<TbPraise> select = tbPraiseMapper.select(tbPraise);

        if(select.size() != 0){
            int delete = tbPraiseMapper.delete(tbPraise);

            TbComment tbComment = tbCommentMapper.selectByPrimaryKey(comment_id);
            tbComment.setPraise_count(tbComment.getPraise_count()-1);
            int i = tbCommentMapper.updateByPrimaryKey(tbComment);
            return 0;
        }else{
            int insert = tbPraiseMapper.insert(tbPraise);
            TbComment tbComment = tbCommentMapper.selectByPrimaryKey(comment_id);
            tbComment.setPraise_count(tbComment.getPraise_count()+1);
            int i = tbCommentMapper.updateByPrimaryKey(tbComment);
            return 1;
        }
    }

    /**
     * 点赞回复
     * @param reply_id
     * @param user_id
     * @return
     */
    public Integer praiseReply(Integer reply_id,Integer user_id){
        TbPraise tbPraise = new TbPraise();
        tbPraise.setReply_id(reply_id);
        tbPraise.setUser_id(user_id);
        List<TbPraise> select = tbPraiseMapper.select(tbPraise);

        if(select.size() != 0){
            int delete = tbPraiseMapper.delete(tbPraise);
            TbReply tbReply = tbReplyMapper.selectByPrimaryKey(reply_id);
            tbReply.setPraise_count(tbReply.getPraise_count()-1);
            int i = tbReplyMapper.updateByPrimaryKey(tbReply);
            return 0;
        }else{
            int insert = tbPraiseMapper.insert(tbPraise);
            TbReply tbReply = tbReplyMapper.selectByPrimaryKey(reply_id);
            tbReply.setPraise_count(tbReply.getPraise_count()+1);
            int i = tbReplyMapper.updateByPrimaryKey(tbReply);
            return 1;
        }
    }

    /**
     * 点赞文章
     */
    public Integer praiseIssue(Integer issue_id,Integer user_id){
        TbPraise tbPraise = new TbPraise();
        tbPraise.setIssue_id(issue_id);
        tbPraise.setUser_id(user_id);
        List<TbPraise> select = tbPraiseMapper.select(tbPraise);

        if(select.size() != 0){
            int delete = tbPraiseMapper.delete(tbPraise);
            TbIssue tbIssue = tbIssueMapper.selectByPrimaryKey(issue_id);
            tbIssue.setPraise_count(tbIssue.getPraise_count()-1);
            int i = tbIssueMapper.updateByPrimaryKey(tbIssue);
            return 0;
        }else{
            int insert = tbPraiseMapper.insert(tbPraise);
            TbIssue tbIssue = tbIssueMapper.selectByPrimaryKey(issue_id);
            tbIssue.setPraise_count(tbIssue.getPraise_count()+1);
            int i = tbIssueMapper.updateByPrimaryKey(tbIssue);
            return 1;
        }
    }
}
