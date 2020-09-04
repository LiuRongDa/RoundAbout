package com.aaa.dao;

import com.aaa.entity.TbReport;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbReportMapper extends MyMapper<TbReport> {
    List<TbReport> selePage(@Param("report_content")String report_content, @Param("report_data")String report_data,@Param("report_id")Integer report_id,@Param("bereport_user_id")Integer bereport_user_id);
}