package com.aaa.dao;

import com.aaa.entity.TbTopic;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbTopicMapper extends MyMapper<TbTopic> {
    List<TbTopic> queryAll(@Param("topic_id") Integer topic_id,@Param("topic_name")String topic_name);
}