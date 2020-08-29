package com.aaa.dao;

import com.aaa.entity.TbUser;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser> {
    //关联 trade 表 查询全部
    List<TbUser> userAndTradeQueryAll();

}