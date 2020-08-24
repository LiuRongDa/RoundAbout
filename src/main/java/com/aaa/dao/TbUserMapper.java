package com.aaa.dao;

import com.aaa.entity.TbUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.MyMapper;

public interface TbUserMapper extends MyMapper<TbUser> {
    @Select("select * from tb_user where userName=#{userName}")
    TbUser findName(String userName);
}