package com.aaa.controller.front;

import com.aaa.entity.TbArticleGambit;
import com.aaa.entity.TbComment;
import com.aaa.entity.TbGambit;
import com.aaa.service.TbArticleService;
import com.aaa.service.TbCommentService;
import com.aaa.service.TbGambitService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("queryAll")
    public String queryAll(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbArticleService.query(pageNum,pageSize);
        model.addAttribute("art",pageInfo);
        return "main";
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
