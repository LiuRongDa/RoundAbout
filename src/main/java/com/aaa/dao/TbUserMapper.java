package com.aaa.dao;

import com.aaa.entity.TbStaff;
import com.aaa.entity.TbUser;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser> {

    //查询用户被谁关注
    List<TbUser> queryAttentionUser(@Param("user_id") Integer user_id);

    //查询用户关注的人
    List<TbUser> queryUserAttention(@Param("user_id") Integer user_id);

    //关联 trade 表 查询全部
    List<TbUser> userAndTradeQueryAll(@Param("user_name")String user_name);

    Boolean add(TbUser tbUser);

    Boolean upState(@Param("user_state")Integer user_state,@Param("user_id")Integer user_id);

    List<TbUser> queryround();
}