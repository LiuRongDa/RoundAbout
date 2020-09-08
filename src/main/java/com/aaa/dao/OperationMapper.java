package com.aaa.dao;

import com.aaa.entity.Operation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface OperationMapper extends MyMapper<Operation> {
    List<Operation> selePage(@Param("operation_content")String operation_content,@Param("operation_time")String operation_time);

    Boolean add(Operation operation);
}