package com.aaa.service;

import com.aaa.dao.TbArticleGambitMapper;
import com.aaa.dao.TbGambitMapper;
import com.aaa.entity.TbArticleGambit;
import com.aaa.entity.TbGambit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artls
 * @date 2020/8/31 10:13
 */
@Service
public class TbGambitService {
    @Resource
    TbGambitMapper tbGambitMapper;

    @Resource
    TbArticleGambitMapper tbArticleGambitMapper;

    /**
     *查询指定文章的话题
     */
    public List<TbGambit> queryById(Integer article_id){
        TbArticleGambit tbArticleGambit = new TbArticleGambit();
        tbArticleGambit.setArticle_id(article_id);
        List<TbArticleGambit> tbArticleGambits = tbArticleGambitMapper.select(tbArticleGambit);
        List<TbGambit> tbGambits = new ArrayList<>();
        for(int i = 0;i<tbArticleGambits.size();i++){
            TbGambit tbGambit1 = tbGambitMapper.selectByPrimaryKey(tbArticleGambits.get(i).getGambit_id());
            /*System.out.println(i+"--->"+tbGambit1);*/
            tbGambits.add(i,tbGambit1);
        }
        return tbGambits;
    }
}
