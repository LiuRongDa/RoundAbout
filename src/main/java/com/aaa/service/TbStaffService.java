package com.aaa.service;

import com.aaa.dao.TbStaffMapper;
import com.aaa.entity.TbStaff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/25 11:13
 */
@Service
public class TbStaffService {
    @Resource
    TbStaffMapper tbStaffMapper;

    public TbStaff findByName(TbStaff tbStaff){
        TbStaff staff = tbStaffMapper.selectOne(tbStaff);
        return staff;
    }
}
