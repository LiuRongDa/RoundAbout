package com.aaa.dao;

import com.aaa.entity.TbReport;
import tk.mybatis.MyMapper;

import java.util.List;

public interface TbReportMapper extends MyMapper<TbReport> {
    List<TbReport> selePage();
}