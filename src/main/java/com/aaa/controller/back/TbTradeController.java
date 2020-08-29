package com.aaa.controller.back;

import com.aaa.entity.TbTrade;
import com.aaa.service.TbTradeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/29 8:57
 */
@RestController
@CrossOrigin
@RequestMapping("BackTbTrade")
public class TbTradeController {
    @Resource
    TbTradeService tbTradeService;

    @RequestMapping("queryAll")
    public List<TbTrade> queryAll(){
        return  tbTradeService.queryAll();
    }
}
