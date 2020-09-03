package com.aaa.service;

import com.aaa.dao.TbCommentMapper;
import com.aaa.dao.TbReplyMapper;
import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbComment;
import com.aaa.entity.TbReply;
import com.aaa.entity.TbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/31 10:44
 */
@Service
public class TbCommentService {
    @Resource
    TbCommentMapper tbCommentMapper;

    @Resource
    TbReplyMapper tbReplyMapper;

    @Resource
    TbUserMapper tbUserMapper;

    /**
     * 查询指定文章下的评论(带用户),回复(带用户)
     * 还没写[回复(带用户)]
     */
    public List<TbComment> queryById(Integer article_id){
        TbComment tbComment = new TbComment();
        tbComment.setArticle_id(article_id);
        List<TbComment> tbComments = tbCommentMapper.select(tbComment);
        //查询评论回复
        /*TbReply tbReply = new TbReply();
        List<TbReply> tbReplis = new ArrayList<>();*/

        TbUser tbUser = new TbUser();
        for(int i = 0;i < tbComments.size(); i++){
            tbUser.setUser_id(tbComments.get(i).getUser_id());
            TbUser tbUser1 = tbUserMapper.selectOne(tbUser);
            tbComments.get(i).setTbUser(tbUser1);
            /*tbReply.setComment_id(tbComments.get(i).getComment_id());
            List<TbReply> select = tbReplyMapper.select(tbReply);*/
        }

        return tbComments;
    }
}
