package com.aaa.dao;

import com.aaa.entity.TbUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser> {
}