package com.aaa.controller.front;

import com.aaa.entity.TbArticle;
import com.aaa.entity.TbIssueGambit;
import com.aaa.service.TbArticleService;
import com.aaa.service.TbIssueService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/28 9:27
 */
@Controller
@RequestMapping("tb_Issue")
public class TbIssueController {
    @Resource
    TbIssueService tbIssueService;

    @Resource
    TbArticleService tbArticleService;

    @RequestMapping("queryAll")
    public String queryAll(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbIssueService.queryAll(pageNum,pageSize);
        model.addAttribute("iss",pageInfo);
        return "issue_main";
    }

    @RequestMapping("queryhot")
    public String queryhot(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbIssueService.queryhot(pageNum,pageSize);
        model.addAttribute("iss",pageInfo);
        return "issue_hot";
    }

    @RequestMapping("queryById")
    public String queryById(Model model,Integer id){
        List<TbIssueGambit> tbIssueGambits = tbIssueService.queryById(id);
        List<TbArticle> tbArticles = tbArticleService.queryByIdIss(id);
        model.addAttribute("art",tbArticles);
        model.addAttribute("issue",tbIssueGambits);
        return "issue_details";
    }
}
