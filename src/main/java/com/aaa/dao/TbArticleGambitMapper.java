package com.aaa.dao;

import com.aaa.entity.TbArticleGambit;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbArticleGambitMapper extends MyMapper<TbArticleGambit> {

    List<TbArticleGambit> queryAll();
}