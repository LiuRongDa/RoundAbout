package com.aaa.dao;

import com.aaa.entity.TbGambit;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbGambitMapper extends MyMapper<TbGambit> {
    //查询全部
    List<TbGambit> queryAll(@Param("gambit_id")Integer gambit_id,@Param("gambit_name") String gambit_name);
}