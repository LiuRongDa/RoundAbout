package com.aaa.dao;

import com.aaa.entity.TbRole;
import com.aaa.entity.TbStaff;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbStaffMapper extends MyMapper<TbStaff> {

    List<TbStaff> queryStallAndRole(@Param("staff_name") String staff_name);

    /**
     * 添加员工信息
     * @param staff
     * @return
     */
    Boolean add(TbStaff staff);

    /**
     * 修改员工信息
     * @param tbStaff
     * @return
     */
    Boolean update(TbStaff tbStaff);

    /**
     * 删除员工   根据Id修改员工的状态
     * @param staff_id
     * @return
     */
    Boolean upState(@Param("staff_id") Integer staff_id);

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TbStaff> selePage(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    /*List<TbStaff> seleSeche(@Param("staff_name") String staff_name);*/
}