package com.aaa.service;

import com.aaa.dao.TbTradeMapper;
import com.aaa.entity.TbTrade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/28 17:29
 */
@Service
public class TbTradeService {
    @Resource
    TbTradeMapper tbTradeMapper;

    /**
     * 查询全部
     * @return
     */
    public List<TbTrade> queryAll(){
        List<TbTrade> tbTrades = tbTradeMapper.selectAll();
        return tbTrades;
    }
}
