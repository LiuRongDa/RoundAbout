package com.aaa.service;

import com.aaa.dao.TbArticleGambitMapper;
import com.aaa.entity.TbArticleGambit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/28 10:44
 */
@Service
public class TbArticleService {
    @Resource
    TbArticleGambitMapper tbArticleGambitMapper;

    /**
     * 查询所有文章信息(分页)
     *
     * @return
     */
    public PageInfo query(Integer pageNum,Integer pageSize){
        if (pageNum == null) {
            PageHelper.startPage(1,2);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbArticleGambit> tbArticleGambits = tbArticleGambitMapper.queryAll();
        PageInfo pageInfo = new PageInfo(tbArticleGambits);
        return pageInfo;
    }


}