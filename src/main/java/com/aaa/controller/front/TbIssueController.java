package com.aaa.controller.front;

import com.aaa.entity.*;
import com.aaa.service.TbArticleService;
import com.aaa.service.TbCommentService;
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

    @Resource
    TbCommentService tbCommentService;


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

    @RequestMapping("addcomm")
    public String addcomm(Model model,Integer user_id,String comment_content,Integer article_id){
        Integer integer = tbCommentService.insertIssComment(user_id, comment_content, article_id);
        List<TbComment> tbComments = tbCommentService.queryById(article_id);
        model.addAttribute("tbComments",tbComments);
        return "issue_details::div2";

    }

    @RequestMapping("showReply")
    public String showReply(Model model,Integer comment_id){
        System.out.println(comment_id);
        List<TbReply> tbReplies = tbCommentService.queryByIdReply(comment_id);
        model.addAttribute("tbReplies",tbReplies);
        System.out.println(tbReplies);
        return "issue_details::div3";
    }

    @RequestMapping("showcomm")
    public String showcomm(Model model,Integer article_id){
        System.out.println(article_id);
        List<TbComment> tbComments = tbCommentService.queryByIdComm(article_id);
        System.out.println(tbComments);
        model.addAttribute("tbComments",tbComments);
        return "issue_details::div2";
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
