package com.aaa.service;

import com.aaa.dao.TbReportMapper;
import com.aaa.entity.TbReport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/3 9:00
 */
@Service
public class TbReportService {
    @Resource
    TbReportMapper tbReportMapper;

    /**
     * LRD  后台  分页+模糊查询
     * @param pageNum
     * @param pageSize
     * @param report_content
     * @param report_data
     * @return
     */
    public PageInfo<TbReport> selePage(Integer pageNum, Integer pageSize, String report_content, String report_data,Integer report_id,Integer bereport_user_id){
        if(pageNum==null || pageNum==0) pageNum = 1;
        if(pageSize==null || pageSize==0) pageSize = 2;
        PageHelper.startPage(pageNum,pageSize);
        List<TbReport> tbReports =tbReportMapper.selePage(report_content,report_data,report_id,bereport_user_id);
        PageInfo<TbReport> pageInfo=new PageInfo<>(tbReports);
        return pageInfo;
    }

    /**
     * LRD 后台 查看详情
     * @param report_id
     * @return
     */
    public List<TbReport> showMore(Integer report_id,Integer bereport_user_id){
        List<TbReport> tbReports = tbReportMapper.selePage(null, null, report_id,bereport_user_id);
        return tbReports;
    }
}
