package com.aaa.controller.front;

import com.aaa.service.TbArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author Artls
 * @date 2020/8/28 10:42
 */
@Controller
@RequestMapping("tb_Article")
public class TbArticleController {
    @Resource
    TbArticleService tbArticleService;

    @RequestMapping("queryAll")
    public String queryAll(Model model,Integer pageNum,Integer pageSize){
        PageInfo pageInfo = tbArticleService.query(pageNum,pageSize);
        model.addAttribute("art",pageInfo);
        return "main";
    }
}
