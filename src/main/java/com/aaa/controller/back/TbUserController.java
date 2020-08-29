package com.aaa.controller.back;

import com.aaa.entity.TbUser;
import com.aaa.service.TbUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/24 18:40
 */
@RestController
@RequestMapping("BackTbUser")
@CrossOrigin
public class TbUserController {
    @Resource
    TbUserService tbUserService;

   /* @RequestMapping("query")
    public TbUser query(){
        return tbUserService.queryProfession();
    }*/


  @RequestMapping("userAndTradeQueryAll")
    public PageInfo<TbUser> userAndTradeQueryAll(Integer pageNum,Integer pageSize){
      System.out.println("----------------------"+pageNum);
      PageInfo<TbUser> tbUserPageInfo = tbUserService.selePage(pageNum, pageSize);
      return tbUserPageInfo;
  }

}
