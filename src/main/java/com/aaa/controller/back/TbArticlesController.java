package com.aaa.controller.back;

import com.aaa.entity.TbArticle;
import com.aaa.service.TbArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/7 19:05
 */
@CrossOrigin
@RestController
@RequestMapping("BackTbArticle")
public class TbArticlesController {
    @Resource
    TbArticleService tbArticleService;

    /**
     * 分页+模糊查询
     * @param pageNum
     * @param pageSize
     * @param article_title
     * @param article_content
     * @return
     */
    @RequestMapping("selePage")
    public PageInfo<TbArticle> selePage(Integer pageNum, Integer pageSize, String article_title, String article_content,String article_date){
        PageInfo<TbArticle> tbArticlePageInfo = tbArticleService.selePage(pageNum, pageSize, article_title, article_content,article_date);
        return tbArticlePageInfo;
    }

    /**
     * 查看详情
     * @param article_id
     * @return
     */
    @RequestMapping("seleOne")
    public TbArticle seleOne(Integer article_id){
        TbArticle tbArticle = tbArticleService.seleOne(article_id);
        return tbArticle;
    }

    /**
     * 删除文章
     * @param article_id
     * @return
     */
    @RequestMapping("del")
    public PageInfo<TbArticle> del(Integer article_id){
        tbArticleService.del(article_id);
        return selePage(null, null,null,null,null);
    }
}
