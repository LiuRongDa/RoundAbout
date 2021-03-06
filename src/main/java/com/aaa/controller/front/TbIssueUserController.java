package com.aaa.controller.front;

import com.aaa.entity.TbIssueUser;
import com.aaa.entity.TbUser;
import com.aaa.service.TbIssueUserService;
import com.aaa.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/9/9 14:312
 */
@Controller
@RequestMapping("/Reception/tb_issuser")
public class TbIssueUserController {
    @Resource
    TbIssueUserService tbIssueUserService;

    @Resource
    TbUserService tbUserService;

    @RequestMapping("queryIssueUser")
    public String queryIssueUser(Model model,Integer user_id){
        List<TbIssueUser> tbIssueUsers = tbIssueUserService.queryIssueUser(user_id);
        List<TbUser> queryround = tbUserService.queryround();
        model.addAttribute("query",queryround);
        model.addAttribute("tbIssueUsers",tbIssueUsers);
        return "wait_reploy";
    }

    @RequestMapping("removeIssue")
    public String removeIssue(Model model,Integer user_id,Integer issue_id){
        tbIssueUserService.removeIssue(user_id,issue_id);
        List<TbIssueUser> tbIssueUsers = tbIssueUserService.queryIssueUser(user_id);
        model.addAttribute("tbIssueUsers",tbIssueUsers);
        return "wait_reploy::div1";
    }


}
