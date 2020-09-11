package com.aaa.dao;

import com.aaa.entity.TbArticleTopic;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

public interface TbArticleTopicMapper extends MyMapper<TbArticleTopic> {
    Boolean delByArticle(@Param("article_id")Integer article_id);
}