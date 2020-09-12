package com.aaa.controller.front;

import com.aaa.entity.*;
import com.aaa.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/28 10:422
 */
@Controller
@RequestMapping("/Reception/tb_Article")
public class TbArticleController {
    @Resource
    TbArticleService tbArticleService;
    @Resource
    TbGambitService tbGambitService;

    @Resource
    TbCommentService tbCommentService;

    @Resource
    TbPraiseService tbPraiseService;

    @Resource
    TbTopicService tbTopicService;

    @Resource
    TbUserService tbUserService;

    @RequestMapping("queryLike")
    public String queryLike(Model model,String like){
        System.out.println("like--->"+like);
        if(like==null || like==""){
            return "redirect:queryAll";
        }else{
            List<TbArticleGambit> tbArticleGambits = tbArticleService.queryLike(like);
            List<TbUser> queryround = tbUserService.queryround();
            model.addAttribute("query",queryround);
            model.addAttribute("art",tbArticleGambits);
            model.addAttribute("like",like);
            return "like_article";
        }
    }

    /**
     * 举报文章
     * @param article_id
     * @param user_id
     * @param report_content
     * @return
     */
    @RequestMapping("reportArticle")
    @ResponseBody
    public Integer reportArticle(Integer article_id,Integer user_id,String report_content){

        return 0;
    }

    /**
     * 点赞文章
     * @param article_id
     * @param user_id
     * @return
     */
    @RequestMapping("praiseArticle")
    @ResponseBody
    public Integer praiseArticle(Integer article_id,Integer user_id){
        System.out.println("article_id--->"+article_id);
        System.out.println("user_id--->"+user_id);
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
        System.out.println("comment_id--->"+comment_id);
        System.out.println("user_id--->"+user_id);
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
        System.out.println("reply_id--->"+reply_id);
        System.out.println("user_id--->"+user_id);
        Integer integer = tbPraiseService.praiseReply(reply_id,user_id);
        return integer;
    }

    /**
     * 发布问题
     */
    @RequestMapping("insertArticle")
    public String insertArticle(Integer user_id,String article_title,String article_content,String topics,Integer topic_id){
        System.out.println("user_id--->"+user_id);
        System.out.println("article_title--->"+article_title);
        System.out.println("article_content--->"+article_content);
        System.out.println("topics---->"+topics);
        System.out.println("topic_id--->"+topic_id);

        Integer integer = tbArticleService.insertArticle(user_id, article_title, article_content, topics,topic_id);
        return "redirect:../tb_Article/queryAll";
    }

    @RequestMapping("w_a")
    public String write_article(Model model, HttpSession session){
        TbUser user = (TbUser) session.getAttribute("user");
        List<TbTopic> tbTopics = tbTopicService.queryUser(user.getUser_id());
        List<TbGambit> query = tbGambitService.query();
        model.addAttribute("gambits",query);
        model.addAttribute("tbTopics",tbTopics);
        return "write_article";
    }

    /**
     * 最新文章 分页
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("queryAll")
    public String queryAll(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbArticleService.queryAll(pageNum,pageSize);
        List<TbUser> queryround = tbUserService.queryround();
        model.addAttribute("query",queryround);
        model.addAttribute("art",pageInfo);
        return "main";
    }

    /**
     * 添加评论
     * @param model
     * @param article_id
     * @param comment_content
     * @param user_id
     * @return
     */
    @RequestMapping("addComment")
    public String addComment(Model model,Integer article_id,String comment_content,Integer user_id){
        Integer integer = tbCommentService.insertComment(article_id, comment_content, user_id);
        return "redirect:queryById?id="+article_id+"";
    }

    /**
     * 添加回复并回显
     * @param user_id
     * @param reply_idto
     * @param comment_id
     * @param comment_content
     */
    @RequestMapping("addReply")
    public String addReply(Model model,Integer user_id, Integer reply_idto, Integer comment_id, String comment_content,Integer article_id){
        System.out.println("user_id-->"+user_id);
        System.out.println("reply_idto-->"+reply_idto);
        System.out.println("comment_id-->"+comment_id);
        System.out.println("comment_content-->"+comment_content);
        Integer integer = tbCommentService.insertReply(user_id, reply_idto, comment_id, comment_content);
        List<TbComment> tbComments = tbCommentService.queryById(article_id);
        model.addAttribute("tbComments",tbComments);
        return "article_details::div1";
    }


    /**
     * 热门文章 分页
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("queryhot")
    public String queryhot(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbArticleService.queryhot(pageNum,pageSize);
        List<TbUser> queryround = tbUserService.queryround();
        model.addAttribute("query",queryround);
        model.addAttribute("art",pageInfo);
        return "article_hot";
    }

    /**
     * 浏览次数+1
     * @param id
     * @return
     */
    @RequestMapping("addcount")
    public String addcount(Integer id){
        tbCommentService.addcount(id);
        return "redirect:queryById?id="+id+"";
    }

    @RequestMapping("queryById")
    public String queryById(Model model,Integer id){
        List<TbArticleGambit> tbArticleGambits = tbArticleService.queryById(id);
        List<TbGambit> tbGambits = tbGambitService.queryById(id);
        List<TbComment> tbComments = tbCommentService.queryById(id);
        model.addAttribute("tbComments",tbComments);
        model.addAttribute("gambits",tbGambits);
        model.addAttribute("art",tbArticleGambits);
        return "article_details";
    }

}
