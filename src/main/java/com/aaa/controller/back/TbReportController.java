package com.aaa.controller.back;

import com.aaa.entity.TbReport;
import com.aaa.service.TbReportService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/3 9:04
 */
@RestController
@RequestMapping("BackTbReport")
@CrossOrigin
public class TbReportController {
    @Resource
    TbReportService tbReportService;


    @RequestMapping("selePage")
    public PageInfo<TbReport> selePage(Integer pageNum, Integer pageSize){
        PageInfo<TbReport> tbReportPageInfo = tbReportService.selePage(pageNum, pageSize);
        return tbReportPageInfo;
    }
}
