package com.aaa.service;

import com.aaa.dao.TbPowerMapper;
import com.aaa.entity.TbPower;
import com.aaa.entity.items;
import com.aaa.utils.JacksonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/27 19:53
 */
@Service
public class TbPowerService {
    @Resource
    TbPowerMapper tbPowerMapper;

    public String queryStair(Integer role_id) {
        String s = "";
        List<TbPower> tbPowers = tbPowerMapper.queryMenu(role_id);
        List<items> itemsArrayList = new ArrayList<items>();
        for (TbPower t : tbPowers) {
            //为对象赋值
            items it = new items();
            it.setIcon(t.getIcon());
            it.setIndex(t.getPower_url());
            it.setTitle(t.getPower_name());
            Integer id = t.getPower_id();
            for (TbPower t1 : tbPowers) {
                //判断当前id 是否有匹配他的fid  如果有就证明他还有子级 调用addStair方法添加子级
                if (id == t1.getFid()) {
                    it = addStair(it, t, tbPowers);
                    break;
                }
            }
            //fid 为0 就是一级菜单
            if (t.getFid() == 0)
            itemsArrayList.add(it);
        }
        try {
            s = JacksonUtils.obj2json(itemsArrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        s = s.replaceAll("\",\"subs\":null", "\"");
        return s;

        /*","subs":null*/
    }

    public items addStair(items item, TbPower tbPower, List<TbPower> list) {
        //子级的编号
        Integer id = tbPower.getPower_id();
        List<items> itemsList = new ArrayList<items>();
        for (TbPower t : list) {
            if (id == t.getFid()) {
                items it = new items();
                it.setIndex(t.getPower_url());
                it.setTitle(t.getPower_name());
                Integer id2 = t.getPower_id();
                for (TbPower t2 : list) {
                    if (id2 == t2.getFid()) {
                        it = addStair(it, t, list);
                        break;
                    }
                }
                itemsList.add(it);
                //添加子级
                item.setSubs(itemsList);
            }
        }
        return item;
    }
}
