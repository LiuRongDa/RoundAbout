package com.aaa.service;

import com.aaa.dao.TbIdeaMapper;
import com.aaa.entity.TbIdea;
import com.aaa.entity.TbIssue;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/2 15:53
 */
@Service
public class TbIdeaService {
    @Resource
    TbIdeaMapper tbIdeaMapper;

    /**
     * LRD  后台  分页 模糊查询
     * @param pageNum
     * @param pageSize
     * @param idea_content
     * @return
     */
    public PageInfo<TbIdea> selePage(Integer pageNum, Integer pageSize, String idea_content){
        if(pageNum==null || pageNum==0) pageNum = 1;
        if(pageSize==null || pageSize==0) pageSize = 2;
        PageHelper.startPage(pageNum,pageSize);
        List<TbIdea> tbIdeas =tbIdeaMapper.selePage(idea_content);
        PageInfo<TbIdea> pageInfo=new PageInfo<>(tbIdeas);
        return pageInfo;
    }

    /**
     * LRD  后台  添加修改
     * @param tbIdea
     * @return
     */
    public Boolean save(TbIdea tbIdea){
        if(tbIdea.getIdea_id()==null){
            Boolean add = tbIdeaMapper.add(tbIdea);
            if(add) return true;
            return false;
        }else{
            Boolean update = tbIdeaMapper.update(tbIdea);
            if(update) return true;
            return false;
        }
    }

    /**
     * LRD 后台  删除
     * @param idea_id
     * @return
     */
    public Boolean del(Integer idea_id){
        int i = tbIdeaMapper.deleteByPrimaryKey(idea_id);
        if(i==1)return true;
        return false;
    }
}
