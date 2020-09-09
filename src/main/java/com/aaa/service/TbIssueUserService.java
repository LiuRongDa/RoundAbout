package com.aaa.service;

import com.aaa.dao.TbIssueMapper;
import com.aaa.dao.TbIssueUserMapper;
import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbIssue;
import com.aaa.entity.TbIssueUser;
import com.aaa.entity.TbUser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/9/9 14:32
import com.aaa.dao.TbIssueUserMapper;
import com.aaa.entity.TbIssueUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/9 3:16
 */
@Service
public class TbIssueUserService {
    @Resource
    TbIssueUserMapper tbIssueUserMapper;

    @Resource
    TbIssueMapper tbIssueMapper;

    @Resource
    TbUserMapper tbUserMapper;

    /**
     * 等待回答
     * @param user_id
     * @return
     */
    public List<TbIssueUser> queryIssueUser(Integer user_id){
        TbIssueUser tbIssueUser = new TbIssueUser();
        tbIssueUser.setUser_id(user_id);
        List<TbIssueUser> select = tbIssueUserMapper.select(tbIssueUser);

        for(TbIssueUser t : select){
            TbIssue tbIssue = tbIssueMapper.selectByPrimaryKey(t.getIssue_id());
            TbUser tbUser = tbUserMapper.selectByPrimaryKey(tbIssue.getUser_id());
            tbIssue.setTbUser(tbUser);
            t.setTbIssue(tbIssue);
        }

        return select;
    }

    /**
     * 忽略提问
     * @return
     */
    public void removeIssue(Integer user_id,Integer issue_id){
        TbIssueUser tbIssueUser = new TbIssueUser();
        tbIssueUser.setIssue_id(issue_id);
        tbIssueUser.setUser_id(user_id);

        tbIssueUserMapper.delete(tbIssueUser);
    }

    /**
     * 查到所有用户
     * @return
     */
    public List<TbUser> queryUserAll(){
        List<TbUser> tbUsers = tbUserMapper.selectAll();
        return tbUsers;
    }

    /**
     *  邀请回答
     * @param user_id
     * @param issue_id
     * @return
     */
    public Integer addIssueUser(Integer user_id,Integer issue_id){
        TbIssueUser tbIssueUser = new TbIssueUser();
        tbIssueUser.setUser_id(user_id);
        tbIssueUser.setIssue_id(issue_id);

        List<TbIssueUser> select = tbIssueUserMapper.select(tbIssueUser);
        if(select.size() == 0){
            int insert = tbIssueUserMapper.insert(tbIssueUser);
            return 1;
        }else{
            return 0;
        }
    /**
     * LRD 后台 添加问题用户桥梁表信息
     * @param tbIssueUser
     * @return
     */
    public Boolean add(TbIssueUser tbIssueUser){
        int insert = tbIssueUserMapper.insert(tbIssueUser);
        if(insert==1)return true;
        return false;
    }
}
