package com.aaa.dao;

import com.aaa.entity.TbArticleGambit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbArticleGambitMapper extends MyMapper<TbArticleGambit> {

    /**
     * 查询所有文章的基本信息
     * @return
     */
    List<TbArticleGambit> queryAll();

    /**
     * 查询单个文章
     * @param article_id
     * @return
     */
    List<TbArticleGambit> queryById(@Param("article_id") Integer article_id);
}