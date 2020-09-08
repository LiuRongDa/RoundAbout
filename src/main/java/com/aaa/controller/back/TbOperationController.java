package com.aaa.controller.back;

import com.aaa.entity.Operation;
import com.aaa.service.TbOperationService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/8 12:33
 */
@CrossOrigin
@RestController
@RequestMapping("BackTbOperaion")
public class TbOperationController {
    @Resource
    TbOperationService tbOperationService;

    @RequestMapping("selePage")
    public PageInfo<Operation> selePage(Integer pageNum, Integer pageSize, String operation_content, String operation_time){
        PageInfo<Operation> operationPageInfo = tbOperationService.selePage(pageNum, pageSize, operation_content, operation_time);
        return operationPageInfo;
    }
}
