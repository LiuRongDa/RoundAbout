package com.aaa.service;

import com.aaa.dao.TbArticleMapper;
import com.aaa.dao.TbArticleTopicMapper;
import com.aaa.dao.TbTopicMapper;
import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbArticle;
import com.aaa.entity.TbArticleTopic;
import com.aaa.entity.TbTopic;
import com.aaa.entity.TbUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/31 19:13
 */
@Service
public class TbTopicService {
    @Resource
    TbTopicMapper tbTopicMapper;

    @Resource
    TbUserMapper tbUserMapper;

    @Resource
    TbArticleTopicMapper tbArticleTopicMapper;

    @Resource
    TbArticleMapper tbArticleMapper;

    /**
     * 查询指定专栏
     * @param topic_id
     * @return
     */
    public TbTopic queryById(Integer topic_id){
        TbUser tbUser = new TbUser();
        TbTopic tbTopic = tbTopicMapper.selectByPrimaryKey(topic_id);
        tbUser.setUser_id(tbTopic.getUser_id());
        List<TbUser> select = tbUserMapper.select(tbUser);
        tbTopic.setTbUser(select);
        return tbTopic;
    }

    /**
     * 查询指定专栏下文章
     * @param topic_id
     * @return
     */
    public List<TbArticleTopic> queryArtById(Integer topic_id){
        TbArticleTopic tbArticleTopic = new TbArticleTopic();
        tbArticleTopic.setTopic_id(topic_id);
        List<TbArticleTopic> TbArticleTopics = tbArticleTopicMapper.select(tbArticleTopic);

        for(TbArticleTopic t : TbArticleTopics){
            TbArticle tbArticle = tbArticleMapper.selectByPrimaryKey(t.getArticle_id());
            TbUser tbUser = tbUserMapper.selectByPrimaryKey(tbArticle.getUser_id());
            tbArticle.setTbUser(tbUser);
            t.setTbArticle(tbArticle);
        }
        return TbArticleTopics;
    }

    /**
     * 随机4条专栏
     * @return
     */
    public List<TbTopic> queryTopic(){
        List<TbTopic> tbTopics = tbTopicMapper.queryTopic();
        return tbTopics;
    }

    /**
     * 最热4条专栏
     * @return
     */
    public List<TbTopic> queryhot(){
        List<TbTopic> tbTopics = tbTopicMapper.queryhot();
        return tbTopics;
    }

    /**
     * 最新4条专栏
     * @return
     */
    public List<TbTopic> querydate(){
        List<TbTopic> tbTopics = tbTopicMapper.querydate();
        return tbTopics;
    }

    /**
     * 查询指定用户的专栏
     * @param user_id
     * @return
     */

    public List<TbTopic> queryUser(Integer user_id){
        TbTopic tbTopic = new TbTopic();
        tbTopic.setUser_id(user_id);
        List<TbTopic> select = tbTopicMapper.select(tbTopic);
        return select;
    }
    /**
     * LRD 后台  查询所有专栏 和专栏下的用户，文章
     * @return
     */
    public List<TbTopic> queryAll(Integer topic_id,String topic_name){
        List<TbTopic> tbTopics = tbTopicMapper.queryAll(topic_id,null);
        return tbTopics;
    }

    /**
     * LRD 后台  添加专栏
     * @param tbTopic
     * @return
     */
    public Boolean add(TbTopic tbTopic){
        int insert = tbTopicMapper.insert(tbTopic);
        if(insert==1)return true;
        return false;
    }

    /**
     * LRD 后台  修改专栏
     * @param tbTopic
     * @return
     */
    public Boolean update(TbTopic tbTopic){
        int i = tbTopicMapper.updateByPrimaryKey(tbTopic);
        if(i==1)return true;
        return false;
    }

    /**
     * LRD 后台  删除专栏
     * @param topic_id
     * @return
     */
    public Boolean del(Integer topic_id){
        //查询该专栏下是否有文章
        List<TbTopic> tbTopics = queryAll(topic_id, null);
        int i=0;
        for (TbTopic t :tbTopics) {
            if(t.getTbArticle().get(0).getArticle_content()==null || t.getTbArticle().get(0).getArticle_content()== ""){
                i= tbTopicMapper.deleteByPrimaryKey(topic_id);
            }
        }
        if(i==1)return true;
        return false;
    }

    /**
     * LRD 后台  分页 +模糊搜索
     * @param pageNum
     * @param pageSize
     * @param topic_id
     * @param topic_name
     * @return
     */
    public PageInfo<TbTopic> selePage(Integer pageNum, Integer pageSize,Integer topic_id,String topic_name){
        if(pageNum==null || pageNum==0){
            PageHelper.startPage(1,2);
        }else if(pageSize==null || pageSize==0){
            PageHelper.startPage(pageNum,2);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbTopic> tbTopics = tbTopicMapper.queryAll(null,topic_name);
        PageInfo<TbTopic> pageInfo=new PageInfo<>(tbTopics);
        return pageInfo;
    }
}
