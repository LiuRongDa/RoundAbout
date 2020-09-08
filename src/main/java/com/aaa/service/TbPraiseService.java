package com.aaa.service;

import com.aaa.dao.TbArticleMapper;
import com.aaa.dao.TbCommentMapper;
import com.aaa.dao.TbPraiseMapper;
import com.aaa.entity.TbArticle;
import com.aaa.entity.TbComment;
import com.aaa.entity.TbPraise;
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


}
