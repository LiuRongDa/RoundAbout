package com.aaa.service;

import com.aaa.dao.TbRoleMapper;
import com.aaa.entity.TbRole;
import com.aaa.entity.TbStaff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/26 18:57
 */
@Service
public class TbRoleService {
    @Resource
    TbRoleMapper tbRoleMapper;

    /**
     * 查询全部角色
     * @return
     */
    public List<TbRole> queryAll(){
        List<TbRole> tbRoles = tbRoleMapper.selectAll();
        return tbRoles;
    }
}
