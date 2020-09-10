package com.aaa.dao;

import com.aaa.entity.TbIssue;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbIssueMapper extends MyMapper<TbIssue> {

    List<TbIssue> selePage(@Param("issue_title")String issue_title,@Param("issue_content")String issue_content);

    Boolean add(TbIssue tbIssue);

    Boolean update(TbIssue tbIssue);
}