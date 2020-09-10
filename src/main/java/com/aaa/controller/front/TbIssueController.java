package com.aaa.controller.front;

import com.aaa.entity.*;
import com.aaa.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/28 9:272
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

    @Resource
    TbGambitService tbGambitService;

    @Resource
    TbPraiseService tbPraiseService;

    @Resource
    TbIssueUserService tbIssueUserService;

    @Resource
    TbReportService tbReportService;

    @Resource
    TbUserService tbUserService;

    @RequestMapping("queryLike")
    public String queryLike(Model model,String like){
        if(like==null || like==""){
            return "redirect:queryAll";
        }else{
            List<TbIssueGambit> tbIssueGambits = tbIssueService.queryLike(like);
            model.addAttribute("like",like);
            model.addAttribute("iss",tbIssueGambits);
            return "like_issue";
        }
    }

    @RequestMapping("reportIssue")
    @ResponseBody
    public Integer reportIssue(Integer issue_id,Integer user_id,String report_content,Integer bereport_user_id){
        System.out.println("issue_id---->"+issue_id);
        System.out.println("user_id---->"+user_id);
        System.out.println("report_content---->"+report_content);
        Integer integer = tbReportService.reportIssue(issue_id, user_id, report_content,bereport_user_id);
        return integer;
    }

    @RequestMapping("reportArticle")
    @ResponseBody
    public Integer reportArticle(Integer article_id,Integer user_id,String report_content,Integer bereport_user_id){
        System.out.println("article_id---->"+article_id);
        System.out.println("user_id---->"+user_id);
        System.out.println("report_content---->"+report_content);
        Integer integer = tbReportService.reportArticle(article_id, user_id, report_content,bereport_user_id);
        return integer;
    }

    @RequestMapping("reportComment")
    @ResponseBody
    public Integer reportComment(Integer comment_id,Integer user_id,String report_content,Integer bereport_user_id){
        System.out.println("comment_id---->"+comment_id);
        System.out.println("user_id---->"+user_id);
        System.out.println("report_content---->"+report_content);
        Integer integer = tbReportService.reportComment(comment_id, user_id, report_content,bereport_user_id);
        return integer;
    }

    @RequestMapping("reportReply")
    @ResponseBody
    public Integer reportReply(Integer reply_id,Integer user_id,String report_content,Integer bereport_user_id){
        System.out.println("reply_id---->"+reply_id);
        System.out.println("user_id---->"+user_id);
        System.out.println("report_content---->"+report_content);
        Integer integer = tbReportService.reportReply(reply_id, user_id, report_content,bereport_user_id);
        return integer;
    }

    /**
     * 点赞问题
     * @param issue_id
     * @param user_id
     * @return
     */
    @RequestMapping("praiseIssue")
    @ResponseBody
    public Integer praiseIssue(Integer issue_id,Integer user_id){
        Integer integer = tbPraiseService.praiseIssue(issue_id, user_id);
        return integer;
    }

    /**
     * 点赞回答
     * @param article_id
     * @param user_id
     * @return
     */
    @RequestMapping("praiseArticle")
    @ResponseBody
    public Integer praiseArticle(Integer article_id,Integer user_id){
        Integer integer = tbPraiseService.praiseArticle(article_id, user_id);
        return integer;
    }

    /**
     * 点赞评论
     * @param comment_id
     * @param user_id
     * @return
     */
    @RequestMapping("praiseComment")
    @ResponseBody
    public Integer praiseComment(Integer comment_id,Integer user_id){
        Integer integer = tbPraiseService.praiseComment(comment_id,user_id);
        return integer;
    }

    /**
     * 点赞回复
     * @param reply_id
     * @param user_id
     * @return
     */
    @RequestMapping("praiseReply")
    @ResponseBody
    public Integer praiseReply(Integer reply_id,Integer user_id){
        Integer integer = tbPraiseService.praiseReply(reply_id,user_id);
        return integer;
    }


    /**
     * 跳转
     * @return
     */
    @RequestMapping("w_i")
    public String write_issue(Model model){
        List<TbGambit> query = tbGambitService.query();
        model.addAttribute("gambits",query);
        return "write_issue";
    }

    /**
     * 发布问题
     */
    @RequestMapping("insertIssue")
    public String insertIssue(Integer user_id,String issue_title,String issue_content,String topics){
        Integer integer = tbIssueService.insertIssue(user_id, issue_title, issue_content,topics);
        return "redirect:queryAll";
    }

    @RequestMapping("addcount")
    public String addcount(Integer id){
        tbIssueService.addCount(id);
        return "redirect:queryById?id="+id+"";
    }

    /**
     * 添加回答
     * @param issue_id
     * @param user_id
     * @param article_content
     * @return
     */
    @RequestMapping("addArticle")
    @ResponseBody
    public Integer addArticle(Integer issue_id,Integer user_id,String article_content){
        Integer integer = tbArticleService.addArticle(issue_id, user_id, article_content);
        return integer;
    }

    @RequestMapping("queryAll")
    public String queryAll(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbIssueService.queryAll(pageNum,pageSize);
        List<TbUser> queryround = tbUserService.queryround();
        model.addAttribute("query",queryround);
        model.addAttribute("iss",pageInfo);
        return "issue_main";
    }

    @RequestMapping("queryhot")
    public String queryhot(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbIssueService.queryhot(pageNum,pageSize);
        List<TbUser> queryround = tbUserService.queryround();
        model.addAttribute("query",queryround);
        model.addAttribute("iss",pageInfo);
        return "issue_hot";
    }

    /**
     * 添加回复的回复
     */
    @RequestMapping("insertReply")
    public String insertReply(Model model,Integer user_id,Integer reply_idto,Integer comment_id,String comment_content){
        Integer integer = tbCommentService.insertReply(user_id, reply_idto, comment_id, comment_content);
        List<TbReply> tbReplies = tbCommentService.queryByIdReply(comment_id);
        model.addAttribute("tbReplies",tbReplies);
        return "issue_details::div3";
    }

    /**
     * 添加回复
     * @param model
     * @param user_id
     * @param reply_idto
     * @param comment_id
     * @param comment_content
     * @return
     */
    @RequestMapping("addreply")
    public String addreply(Model model,Integer user_id,Integer reply_idto,Integer comment_id,String comment_content){
        Integer integer = tbCommentService.insertReply(user_id, reply_idto, comment_id, comment_content);
        List<TbReply> tbReplies = tbCommentService.queryByIdReply(comment_id);
        model.addAttribute("tbReplies",tbReplies);
        return "issue_details::div3";
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
        List<TbGambit> gambits = tbGambitService.queryByIdIss(id);
        List<TbUser> tbUsers = tbIssueUserService.queryUserAll();
        model.addAttribute("art",tbArticles);
        model.addAttribute("issue",tbIssueGambits);
        model.addAttribute("gambits",gambits);
        model.addAttribute("tbusers",tbUsers);

        return "issue_details";
    }

    /**
     *邀请回答
     * @param user_id
     * @param issue_id
     * @return
     */
    @RequestMapping("addIssueUser")
    @ResponseBody
    public Integer addIssueUser(Integer user_id,Integer issue_id){
        TbIssueUser tbIssueUser = new TbIssueUser();
        tbIssueUser.setUser_id(user_id);
        tbIssueUser.setIssue_id(issue_id);
        Integer integer = tbIssueUserService.addIssueUser(user_id, issue_id);
        return integer;
    }
}
