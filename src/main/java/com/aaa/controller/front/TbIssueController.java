package com.aaa.controller.front;

import com.aaa.service.TbIssueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Artls
 * @date 2020/8/28 9:27
 */
@Controller
@RequestMapping("tb_Issue")
public class TbIssueController {
    @Resource
    TbIssueService tbIssueService;

    /*@RequestMapping("queryissue")
    public String queryAllIssue(Model model){
        List<TbIssue> tbIssues = tbIssueService.queryAllIssue();
        model.addAttribute("iss",tbIssues);
        System.out.println("Controller tbIssues-->"+tbIssues);
        return "main";
    }*/

    /*@RequestMapping("query")
    public List<TbIssue> queryAll(){
        return tbIssueService.queryAll();
    }*/
}
