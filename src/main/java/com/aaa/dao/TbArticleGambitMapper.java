package com.aaa.dao;

import com.aaa.entity.TbArticleGambit;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbArticleGambitMapper extends MyMapper<TbArticleGambit> {

    /**
     * 查询所有文章的基本信息(文章，用户  时间倒序)
     * @return
     */
    List<TbArticleGambit> queryAll();

    /**
     *查询所有文章的基本信息(文章，用户  浏览数倒序)
     * @return
     */
    List<TbArticleGambit> queryhot();

    /**
     * 查询单个文章
     * @param article_id
     * @return
     */
    List<TbArticleGambit> queryById(@Param("article_id") Integer article_id);

    /**
     * 条件查询1
     * @param like
     * @return
     */
    List<TbArticleGambit> queryLike(@Param("like") String like);

    /**
     * 根据文章ID删除桥梁表
     * @param article_id
     * @return
     */
    Boolean delByArticleId(@Param("article_id")Integer article_id);
}