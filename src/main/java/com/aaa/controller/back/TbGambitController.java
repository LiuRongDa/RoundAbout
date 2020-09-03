package com.aaa.controller.back;

import com.aaa.entity.TbGambit;
import com.aaa.entity.TbTopic;
import com.aaa.service.TbGambitService;
import com.aaa.utils.JacksonUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/1 11:04
 */
@CrossOrigin
@RestController
@RequestMapping("BackTbGambit")
public class TbGambitController {
    @Resource
    TbGambitService tbGambitService;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("queryAll")
    public List<TbGambit> queryAll(Integer gambit_id,String gambit_name){
        List<TbGambit> tbGambits = tbGambitService.queryAll(gambit_id,null);
        return tbGambits;
    }

    @RequestMapping("selePage")
    public PageInfo<TbGambit> selePage(Integer pageNum, Integer pageSize, Integer gambit_id,String gambit_name){
        PageInfo<TbGambit> tbGambitPageInfo = tbGambitService.selePage(pageNum, pageSize,gambit_id,gambit_name);
        return tbGambitPageInfo;
    }

    @RequestMapping("add")
    public PageInfo<TbGambit> add(String s){
        System.out.println("------------"+s);
        TbGambit tbGambit=new TbGambit();
        try {
            tbGambit= JacksonUtils.json2pojo(s,TbGambit.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Boolean aBoolean = tbGambitService.add(tbGambit);
        if (aBoolean) return selePage(null,null,null,null);
        return null;
    }

    @RequestMapping("update")
    public PageInfo<TbGambit> update(String s){
        TbGambit tbGambit=new TbGambit();
        try {
            tbGambit= JacksonUtils.json2pojo(s,TbGambit.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Boolean aBoolean = tbGambitService.update(tbGambit);
        if (aBoolean) return selePage(null,null,null,null);
        return null;
    }

    @RequestMapping("del")
    public PageInfo<TbGambit> del(Integer gambit_id){
        Boolean del = tbGambitService.del(gambit_id);
        if(del) return selePage(null,null,null,null);
        return null;
    }
}
