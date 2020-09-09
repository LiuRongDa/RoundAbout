package com.aaa.controller.front;

import com.aaa.entity.TbArticleTopic;
import com.aaa.entity.TbTopic;
import com.aaa.service.TbTopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/9/9 1:293
 */
@Controller
@RequestMapping("tb_Topic")
public class TbTopController {
    @Resource
    TbTopicService tbTopicService;

    @RequestMapping("showColumn")
    public String showColumn(Model model){
        List<TbTopic> tbTopics = tbTopicService.queryTopic();
        System.out.println(tbTopics);
        model.addAttribute("tbTopics",tbTopics);
        return "column";
    }

    @RequestMapping("huan")
    public String huan(Model model){
        List<TbTopic> tbTopics = tbTopicService.queryTopic();
        System.out.println(tbTopics);
        model.addAttribute("tbTopics",tbTopics);
        return "column::div1";
    }

    @RequestMapping("hot")
    public String hot(Model model){
        List<TbTopic> tbTopics = tbTopicService.queryhot();
        System.out.println(tbTopics);
        model.addAttribute("tbTopics",tbTopics);
        return "column::div1";
    }

    @RequestMapping("date")
    public String date(Model model){
        List<TbTopic> tbTopics = tbTopicService.querydate();
        System.out.println(tbTopics);
        model.addAttribute("tbTopics",tbTopics);
        return "column::div1";
    }

    /**
     * 浏览量+1
     * @return
     */
    @RequestMapping("addCount")
    public String addCount(Integer topic_id){
        Integer integer = tbTopicService.addCount(topic_id);
        return "redirect:queryById?topic_id="+topic_id+"";
    }

    @RequestMapping("queryById")
    public String queryById(Model model,Integer topic_id){
        TbTopic tbTopic = tbTopicService.queryById(topic_id);
        List<TbArticleTopic> tbArticleTopics = tbTopicService.queryArtById(topic_id);
        model.addAttribute("tbTopic",tbTopic);
        model.addAttribute("tbArticleTopics",tbArticleTopics);
        return "column_details";
    }

    /**
     * 开通专栏
     * @param user_id
     * @param topic_name
     * @return
     */
    @RequestMapping("addTopic")
    @ResponseBody
    public Integer addTopic(Integer user_id,String topic_name){
        Integer integer = tbTopicService.addTopic(user_id, topic_name);
        return integer;
    }

}
