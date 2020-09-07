package com.aaa.controller.back;

import com.aaa.entity.TbReport;
import com.aaa.service.TbReportService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    /**
     * 分页 =+模糊查询
     * @param pageNum
     * @param pageSize
     * @param report_content
     * @param report_data
     * @param report_id
     * @return
     */
    @RequestMapping("selePage")
    public PageInfo<TbReport> selePage(Integer pageNum, Integer pageSize, String report_content, String report_data,Integer report_id){
        PageInfo<TbReport> tbReportPageInfo = tbReportService.selePage(pageNum, pageSize,report_content,report_data,report_id,null);
        return tbReportPageInfo;
    }

    /**
     * 查看详情
     * @param report_id
     * @return
     */
    @RequestMapping("showMore")
    public List<TbReport> showMore(Integer report_id,Integer bereport_user_id){
        List<TbReport> tbReports = tbReportService.showMore(report_id,bereport_user_id);
        return tbReports;
    }


    @RequestMapping("del")
    public PageInfo<TbReport> del(Integer report_id){
        Boolean del = tbReportService.del(report_id);
        System.out.println(del);
        if(del)return selePage(null,null,null,null,null);
        return null;
    }
}
