package com.aaa.service;

import com.aaa.dao.OperationMapper;
import com.aaa.entity.Operation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/8 12:30
 */
@Service
public class TbOperationService {
    @Resource
    OperationMapper operationMapper;

    /**
     * LRD 后台 模糊查询+分页
     * @param pageNum
     * @param pageSize
     * @param operation_content
     * @param operation_time
     * @return
     */
    public PageInfo<Operation> selePage(Integer pageNum, Integer pageSize, String operation_content, String operation_time) {
        if (pageNum == null || pageNum == 0) pageNum = 1;
        if (pageSize == null || pageSize == 0) pageSize = 15;
        PageHelper.startPage(pageNum, pageSize);
        List<Operation> operationList = operationMapper.selePage(operation_content, operation_time);
        PageInfo<Operation> pageInfo = new PageInfo<>(operationList);
        return pageInfo;
    }

    /**
     * LRD 后台 添加操作记录
     * @param operation
     * @return
     */
    public Boolean add(Operation operation){
        Boolean add = operationMapper.add(operation);
        if(add)return true;
        return false;
    }
}
