package com.aaa.service;

import com.aaa.dao.TbTopicMapper;
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
                System.out.println("删除");
                i= tbTopicMapper.deleteByPrimaryKey(topic_id);
                System.out.println("nei"+i);
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
