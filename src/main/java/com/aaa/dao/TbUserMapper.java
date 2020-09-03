package com.aaa.dao;

import com.aaa.entity.TbStaff;
import com.aaa.entity.TbUser;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser> {
    //关联 trade 表 查询全部
    List<TbUser> userAndTradeQueryAll(@Param("user_name")String user_name);

    //分页
   /* PageInfo<TbStaff> selePage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);*/

    Boolean add(TbUser tbUser);

    Boolean upState(@Param("user_state")Integer user_state,@Param("user_id")Integer user_id);
}