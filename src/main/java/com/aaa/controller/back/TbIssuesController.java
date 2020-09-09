package com.aaa.controller.back;

import com.aaa.dao.TbIssueMapper;
import com.aaa.entity.TbIssue;
import com.aaa.entity.TbIssueUser;
import com.aaa.service.TbIssueService;
import com.aaa.service.TbIssueUserService;
import com.aaa.utils.JacksonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/2 10:44
 */
@RestController
@CrossOrigin
@RequestMapping("BackTbIssue")
public class TbIssuesController {
    @Resource
    TbIssueService tbIssueService;

    @Resource
    TbIssueMapper tbIssueMapper;

    @Resource
    TbIssueUserService tbIssueUserService;
    /**
     * 分页查询+模糊搜索
     * @param pageNum
     * @param pageSize
     * @param issue_title
     * @return
     */
    @RequestMapping("selePage")
    public PageInfo<TbIssue> selePage(Integer pageNum, Integer pageSize, String issue_title,String issue_content){
        PageInfo<TbIssue> selePage = tbIssueService.selePage(pageNum, pageSize, issue_title,issue_content);
        return selePage;
    }

    @RequestMapping("save")
    public PageInfo<TbIssue> save(String s){
        TbIssue tbIssue=new TbIssue();
        try {
            tbIssue=JacksonUtils.json2pojo(s,TbIssue.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Boolean save = tbIssueService.save(tbIssue);
        TbIssue tbIssue1=new TbIssue();
        tbIssue1.setIssue_title(tbIssue.getIssue_title());
        tbIssue1.setIssue_content(tbIssue.getIssue_content());
        TbIssue issue = tbIssueMapper.selectOne(tbIssue1);//根据话题标题和话题内容查询
        TbIssueUser tbIssueUser=new TbIssueUser();
        tbIssueUser.setUser_id(tbIssue.getUser_id());
        tbIssueUser.setIssue_id(issue.getIssue_id());
        Boolean add = tbIssueUserService.add(tbIssueUser);//添加桥梁表信息
        if(save && add)return selePage(null,null,null,null);
        return null;
    }
}
