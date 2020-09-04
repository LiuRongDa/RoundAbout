package com.aaa.controller.front;

import com.aaa.entity.TbArticleGambit;
import com.aaa.entity.TbComment;
import com.aaa.entity.TbGambit;
import com.aaa.entity.TbReply;
import com.aaa.service.TbArticleService;
import com.aaa.service.TbCommentService;
import com.aaa.service.TbGambitService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/28 10:42
 */
@Controller
@RequestMapping("tb_Article")
public class TbArticleController {
    @Resource
    TbArticleService tbArticleService;

    @Resource
    TbGambitService tbGambitService;

    @Resource
    TbCommentService tbCommentService;

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
