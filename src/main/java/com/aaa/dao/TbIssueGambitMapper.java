package com.aaa.dao;

import com.aaa.entity.TbIssueGambit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbIssueGambitMapper extends MyMapper<TbIssueGambit> {
    /**
     * 查询所有问题基本信息(问题表，用户表  时间倒序分页)
     * @return
     */
    List<TbIssueGambit> queryAll();

    /**
     * 查询所有问题基本信息(问题表，用户表  浏览数倒序分页)
     */

    List<TbIssueGambit> queryhot();

    /**
     * 查询单个问题
     */
    List<TbIssueGambit> queryById(@Param("issue_id") Integer issue_id);


    List<TbIssueGambit> queryLike(@Param("like") String like);
}