package com.aaa.dao;

import com.aaa.entity.TbArticle;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbArticleMapper extends MyMapper<TbArticle> {
    List<TbArticle> selePage(@Param("article_title")String article_title,@Param("article_content")String article_content,@Param("article_date")String article_date);
}