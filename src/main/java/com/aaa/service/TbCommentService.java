package com.aaa.service;

import com.aaa.dao.*;
import com.aaa.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/31 10:444
 */
@Service
public class TbCommentService {
    @Resource
    TbCommentMapper tbCommentMapper;

    @Resource
    TbReplyMapper tbReplyMapper;

    @Resource
    TbUserMapper tbUserMapper;

    @Resource
    TbArticleMapper tbArticleMapper;

    @Resource
    TbIssueArticleMapper tbIssueArticleMapper;


    /**
     * 添加问题评论
     */
    public Integer insertIssComment(Integer user_id,String comment_content,Integer article_id){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        TbComment tbComment = new TbComment();
        tbComment.setArticle_id(article_id);
        tbComment.setUser_id(user_id);
        tbComment.setComment_content(comment_content);
        tbComment.setComment_date(dateString);
        tbComment.setComment_count(0);
        tbComment.setPraise_count(0);

        int insert = tbCommentMapper.insert(tbComment);

        TbArticle tbArticle = new TbArticle();
        if(insert > 0){
            tbArticle.setArticle_id(article_id);
            tbArticle = tbArticleMapper.selectOne(tbArticle);
            Integer count = tbArticle.getCount()+1;
            tbArticle.setCount(count);

            int i = tbArticleMapper.updateByPrimaryKey(tbArticle);
            System.out.println(i);
        }
        return insert;
    }


    /**
     * 添加评论
     */
    public Integer insertComment(Integer article_id,String comment_content,Integer user_id){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        TbComment tbComment = new TbComment();
        tbComment.setUser_id(user_id);
        tbComment.setComment_content(comment_content);
        tbComment.setArticle_id(article_id);
        tbComment.setComment_date(dateString);
        tbComment.setComment_count(0);
        tbComment.setPraise_count(0);

        int insert = tbCommentMapper.insert(tbComment);

        TbArticle tbArticle = new TbArticle();
        if(insert > 0){
            tbArticle.setArticle_id(article_id);
            tbArticle = tbArticleMapper.selectOne(tbArticle);
            Integer count = tbArticle.getCount()+1;
            tbArticle.setCount(count);

            int i = tbArticleMapper.updateByPrimaryKey(tbArticle);
            System.out.println(i);
        }
        return insert;
    }

    /**
     * 添加回复
     */
    public Integer insertReply(Integer user_id, Integer reply_idto, Integer comment_id, String comment_content){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date());
        TbReply tbReply = new TbReply();
        tbReply.setUser_id(user_id);
        if(reply_idto != null){
            tbReply.setReply_idto(reply_idto);
        }else{
            tbReply.setReply_idto(0);
        }
        tbReply.setPraise_count(0);
        tbReply.setComment_id(comment_id);
        tbReply.setReply_content(comment_content);
        tbReply.setReply_date(dateString);
        int insert = tbReplyMapper.insert(tbReply);

        TbComment tbComment = new TbComment();
        if(insert > 0){
            tbComment.setComment_id(comment_id);
            tbComment = tbCommentMapper.selectOne(tbComment);
            tbComment.setComment_count(tbComment.getComment_count()+1);
            int i = tbCommentMapper.updateByPrimaryKey(tbComment);
        }
        return insert;
    }

    /**
     *  +1浏览次数
     */
    public void addcount(Integer article_id){
        //浏览次数+1
        TbArticle tbArticle = new TbArticle();
        tbArticle.setArticle_id(article_id);
        tbArticle = tbArticleMapper.selectOne(tbArticle);
        tbArticle.setArticle_count(tbArticle.getArticle_count()+1);
        tbArticleMapper.updateByPrimaryKey(tbArticle);
    }

    /**
     * 查询指定文章下的评论
     * @param article_id
     * @return
     */
    public List<TbComment> queryByIdComm(Integer article_id){
        TbComment tbComment = new TbComment();
        tbComment.setArticle_id(article_id);

        List<TbComment> tbComments= tbCommentMapper.select(tbComment);

        TbUser tbUser = new TbUser();
        for (TbComment tc:tbComments){
            tbUser.setUser_id(tc.getUser_id());
            TbUser tbUser1 = tbUserMapper.selectOne(tbUser);
            tc.setTbUser(tbUser1);
        }
        return tbComments;
    }

    /**
     * 查询指定评论下的回复
     */
    public List<TbReply> queryByIdReply(Integer comment_id){
        TbReply tbReply = new TbReply();
        tbReply.setComment_id(comment_id);

        List<TbReply> tbReplies = tbReplyMapper.select(tbReply);
        TbUser tbUser = new TbUser();
        for(TbReply tr : tbReplies){
            tbUser.setUser_id(tr.getUser_id());
            TbUser tbUser1 = tbUserMapper.selectOne(tbUser);
            tr.setTbUser(tbUser1);
            if(tr.getReply_idto() != 0){
                TbReply tbReply1 = tbReplyMapper.selectByPrimaryKey(tr.getReply_idto());
                tbUser.setUser_id(tbReply1.getUser_id());
                TbUser tbUser2 = tbUserMapper.selectOne(tbUser);
                tbReply1.setTbUser(tbUser2);
                tr.setTbReplies(tbReply1);
            }
        }
        return tbReplies;
    }


    /**
     * 查询指定文章下的评论(带用户),回复(带用户)
     */
    public List<TbComment> queryById(Integer article_id){
        TbComment tbComment = new TbComment();
        tbComment.setArticle_id(article_id);
        List<TbComment> tbComments = tbCommentMapper.select(tbComment);

        TbReply tbReply = new TbReply();
        TbUser tbUser = new TbUser();

        /*List<TbReply> replies = new ArrayList<TbReply>();*/
        for(TbComment tc : tbComments){
            tbUser.setUser_id(tc.getUser_id());
            //评论人
            TbUser tbUser1 = tbUserMapper.selectOne(tbUser);

            tc.setTbUser(tbUser1);
            tbReply.setComment_id(tc.getComment_id());
            //所有该评论下的所有回复
            List<TbReply> tbReplies = tbReplyMapper.select(tbReply);
            for(TbReply tr : tbReplies){
                tbUser.setUser_id(tr.getUser_id());
                TbUser tbUser2 = tbUserMapper.selectOne(tbUser);
                tr.setTbUser(tbUser2);
                if(tr.getReply_idto() != 0){
                    TbReply tbReply1 = tbReplyMapper.selectByPrimaryKey(tr.getReply_idto());
                    tbUser.setUser_id(tbReply1.getUser_id());
                    TbUser tbUser3 = tbUserMapper.selectOne(tbUser);

                    tbReply1.setTbUser(tbUser3);
                    tr.setTbReplies(tbReply1);
                }
            }
            tc.setTbReplies(tbReplies);
        }
        return tbComments;
    }
}
