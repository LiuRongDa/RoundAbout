package com.aaa.controller.back;

import com.aaa.entity.Operation;
import com.aaa.entity.TbUser;
import com.aaa.service.TbOperationService;
import com.aaa.service.TbUserService;
import com.aaa.utils.EmailHelper;
import com.aaa.utils.EmailSendUtils;
import com.aaa.utils.JacksonUtils;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    TbOperationService tbOperationService;

    Operation operation=new Operation();
   /* @RequestMapping("query")
    public TbUser query(){
        return tbUserService.queryProfession();
    }*/


    /**
     * 分页+模糊查询
     * @param pageNum
     * @param pageSize
     * @param user_name
     * @return
     */
  @RequestMapping("userAndTradeQueryAll")
    public PageInfo<TbUser> userAndTradeQueryAll(Integer pageNum,Integer pageSize,String user_name){
      PageInfo<TbUser> tbUserPageInfo = tbUserService.selePage(pageNum, pageSize,user_name);
      return tbUserPageInfo;
  }

    /**
     * 添加用户信息
     * @param tbUser
     * @return
     */
  @RequestMapping("add")
  public PageInfo<TbUser> add(String tbUser,Integer staff_id){
      TbUser t=new TbUser();
      try {
          t=JacksonUtils.json2pojo(tbUser,TbUser.class);
      } catch (Exception e) {
          e.printStackTrace();
      }
      Boolean add = tbUserService.add(t);
      if(add){
          operation.setStaff_id(staff_id);
          operation.setUser_name(t.getUser_name());
          operation.setOperation_content("添加用户信息");
          tbOperationService.add(operation);
          return userAndTradeQueryAll(null,null,null);
      }else{
          return null;
      }
  }

    /**
     * 修改状态
     * @param user_state
     * @param user_id
     * @return
     */
    @RequestMapping("upState")
  public PageInfo<TbUser> upState(Integer user_state,Integer user_id,Integer staff_id){
      Boolean aBoolean = tbUserService.upState(user_state, user_id);
        TbUser tbUser = tbUserService.queryByUserId(user_id);
        if(aBoolean){
          operation.setStaff_id(staff_id);
          operation.setUser_name(tbUser.getUser_name());
          if(user_state==0){
              operation.setOperation_content("禁用用户");
          }else{
              operation.setOperation_content("解封用户");
          }
          tbOperationService.add(operation);
          return userAndTradeQueryAll(null,null,null);
      }else{
          return null;
      }
  }

    /**
     * 查询全部
     * @return
     */
  @RequestMapping("queryAll")
  public List<TbUser> queryAll(){
        return tbUserService.queryAll();
  }

    /**
     * 查询被举报人
     * @param user_id
     * @return
     */
  @RequestMapping("queryById")
  public TbUser queryById(Integer user_id){
      return tbUserService.queryById(user_id);
  }
}
