package com.aaa.service;

import com.aaa.dao.TbEducationMapper;
import com.aaa.dao.TbProfessionMapper;
import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbEducation;
import com.aaa.entity.TbProfession;
import com.aaa.entity.TbUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/24 14:10
 */
@Service
public class TbUserService {
    @Resource
    TbUserMapper tbUserMapper;

    @Resource
    TbProfessionMapper tbProfessionMapper;

    @Resource
    TbEducationMapper tbEducationMapper;

    /**
     * 查询用户
     */
    public TbUser queryProfession(){
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(1);
        //查询该用户的职业经历
        TbProfession tbProfession = new TbProfession();
        tbProfession.setUser_id(tbUser.getUser_id());
        List<TbProfession> tbProfessions = tbProfessionMapper.select(tbProfession);
        //查询该用户的教育经历
        TbEducation tbEducation = new TbEducation();
        tbEducation.setUser_id(tbUser.getUser_id());
        List<TbEducation> tbEducations = tbEducationMapper.select(tbEducation);


        tbUser.setTbProfessionList(tbProfessions);
        tbUser.setTbEducations(tbEducations);
        return tbUser;
    }

}
