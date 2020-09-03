package com.aaa.controller.back;

import com.aaa.entity.TbIdea;
import com.aaa.service.TbIdeaService;
import com.aaa.utils.JacksonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/2 16:19
 */
@CrossOrigin
@RestController
@RequestMapping("BackTbIdea")
public class TbIdeaController {
    @Resource
    TbIdeaService tbIdeaService;

    /**
     * 分页 模糊查询
     * @param pageNum
     * @param pageSize
     * @param idea_content
     * @return
     */
    @RequestMapping("selePage")
    public PageInfo<TbIdea> selePage(Integer pageNum, Integer pageSize, String idea_content){
        PageInfo<TbIdea> tbIdeaPageInfo = tbIdeaService.selePage(pageNum, pageSize, idea_content);
        return tbIdeaPageInfo;
    }

    /**
     * 添加修改
     * @param s
     * @return
     */
    @RequestMapping("save")
    public PageInfo<TbIdea> save(String s){
        TbIdea tbIdea=new TbIdea();
        try {
            tbIdea= JacksonUtils.json2pojo(s,TbIdea.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Boolean save = tbIdeaService.save(tbIdea);
        if(save)return selePage(null,null,null);
        return null;
    }

    /**
     * 删除
     * @param idea_id
     * @return
     */
    @RequestMapping("del")
    public PageInfo<TbIdea> del(Integer idea_id){
        Boolean del = tbIdeaService.del(idea_id);
        if(del) return selePage(null,null,null);
        return null;
    }
}
