package com.aaa.service;

import com.aaa.dao.TbReportMapper;
import com.aaa.entity.TbReport;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<TbReport> selePage(Integer pageNum, Integer pageSize){
        if(pageNum==null || pageNum==0) pageNum = 1;
        if(pageSize==null || pageSize==0) pageSize = 2;
        PageHelper.startPage(pageNum,pageSize);
        List<TbReport> tbReports =tbReportMapper.selePage();
        PageInfo<TbReport> pageInfo=new PageInfo<>(tbReports);
        return pageInfo;
    }
}
