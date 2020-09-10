package com.aaa.dao;

import com.aaa.entity.TbIssueArticle;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbIssueArticleMapper extends MyMapper<TbIssueArticle> {
    List<TbIssueArticle> queryUserIssue(@Param("user_id") Integer user_id);
}