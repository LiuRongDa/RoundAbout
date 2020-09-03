package com.aaa.dao;

import com.aaa.entity.TbIdea;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbIdeaMapper extends MyMapper<TbIdea> {
    List<TbIdea> selePage(@Param("idea_content")String idea_content);

    Boolean add(TbIdea tbIdea);

    Boolean update(TbIdea tbIdea);
}