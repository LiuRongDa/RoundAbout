package com.aaa.controller.back;

import com.aaa.entity.TbTopic;
import com.aaa.service.TbTopicService;
import com.aaa.utils.JacksonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/31 19:15
 */
@CrossOrigin
@RequestMapping("BackTbTopic")
@RestController
public class TbTopicController {
    @Resource
    TbTopicService tbTopicService;

    @RequestMapping("queryAll")
    public List<TbTopic> queryAll(Integer topic_id,String topic_name){
        List<TbTopic> tbTopics = tbTopicService.queryAll(topic_id,null);
        return tbTopics;
    }

    /**
     * 添加专栏信息
     * @param s
     * @return
     */
    @RequestMapping("add")
    public PageInfo<TbTopic> add(String s){
        TbTopic tbTopic=new TbTopic();
        try {
            tbTopic=JacksonUtils.json2pojo(s,TbTopic.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Boolean aBoolean = tbTopicService.add(tbTopic);
        if(aBoolean) return selePage(null,null,null,null);
        return null;
    }

    /**
     * 修改员工信息
     * @param s
     * @return
     */
    @RequestMapping("update")
    public PageInfo<TbTopic> update(String s){
        TbTopic tbTopic=new TbTopic();
        try {
            tbTopic=JacksonUtils.json2pojo(s,TbTopic.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Boolean update = tbTopicService.update(tbTopic);
        if(update)return selePage(null,null,null,null);
        return null;
    }

    /**
     * 删除专栏
     * @param topic_id
     * @return
     */
    @RequestMapping("del")
    public PageInfo<TbTopic> del(Integer topic_id){
        Boolean del = tbTopicService.del(topic_id);
        if(del)return selePage(null,null,null,null);
        return null;
    }

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("selePage")
    public PageInfo<TbTopic> selePage(Integer pageNum, Integer pageSize,Integer topic_id,String topic_name){
        PageInfo<TbTopic> tbTopicPageInfo = tbTopicService.selePage(pageNum, pageSize,null,topic_name);
        return tbTopicPageInfo;
    }
}
