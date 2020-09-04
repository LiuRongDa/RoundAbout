package com.aaa.controller;

import com.aaa.entity.TbUser;
import com.aaa.service.TbUserService;
import com.aaa.utils.EmailHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author WH
 * @date 2020/8/31 19:48
 */
@Controller
@RequestMapping("/User")
public class UserMessageController {
    @Resource
    TbUserService tbUserService;

    //跳转到个人信息编辑页面
    @RequestMapping("/toMessage")
    public String toMessage(){
        return "onemessage";
    }

    //忘记密码 查询邮箱是否存在
    @RequestMapping("/byEmail")
    @ResponseBody
    public String byemail(@RequestParam("email") String email){
        TbUser byemail = tbUserService.byemail(email);
        System.out.println(byemail);
        if (byemail!=null) {
            String random =String.valueOf(Math.round(Math.random() * 1000000));
            EmailHelper.sendEmail(email,random);
            String data = byemail.getUser_id()+"_"+random;
            System.out.println(data);
            return data;
        }else {
            String data =String.valueOf(Math.round(Math.random() * 1000000));
            EmailHelper.sendEmail(email,data);
            return data;
        }
    }

    //忘记密码 设置密码
    @RequestMapping("/setpwd")
    @ResponseBody
    public boolean setpwd(@RequestParam("id") int id,@RequestParam("pwd") String pwd){

        return tbUserService.setpwd(id, pwd);
    }
}
