package com.aaa.controller.back;

import com.aaa.entity.TbRole;
import com.aaa.entity.TbStaff;
import com.aaa.service.TbRoleService;
import com.aaa.utils.JacksonUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/26 19:03
 */
@CrossOrigin
@RequestMapping("tbRole")
@RestController
public class TbRoleController {
    @Resource
    TbRoleService tbRoleService;

    @RequestMapping("queryAll")
    public List<TbRole> queryAll(){
        List<TbRole> tbRoles = tbRoleService.queryAll();
        return tbRoles;
    }

}
