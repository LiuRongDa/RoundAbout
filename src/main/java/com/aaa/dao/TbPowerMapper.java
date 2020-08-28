package com.aaa.dao;

import com.aaa.entity.TbPower;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbPowerMapper extends MyMapper<TbPower> {
    List<TbPower> queryMenu(@Param("role_id")Integer role_id);
}