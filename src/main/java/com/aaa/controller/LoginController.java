package com.aaa.controller;

import com.aaa.entity.TbUser;
import com.aaa.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author WH
 * @date 2020/8/26 16:10
 */
@Controller
@RequestMapping("/L")
public class LoginController {

    @Resource
    TbUserService tbUserService;

    @RequestMapping("/login")
    public String reLogin(){
        return "login";
    }
    @RequestMapping("/toLogin")
    @ResponseBody
    public boolean toLogin(HttpSession session, @RequestParam("email") String email,@RequestParam("pwd") String pwd){
        TbUser tbUser = tbUserService.toLogin(email, pwd);
        session.setAttribute("user",tbUser);
        session.setAttribute("id",tbUser.getUser_id());
        if (tbUser==null)
            return false;
        else
            return true;
    }
    @RequestMapping("/toRegister")
    @ResponseBody
    public boolean toRegister(HttpSession session,@RequestParam("email") String email,@RequestParam("pwd") String pwd){
        int i = tbUserService.toRegister(email, pwd);
        if (i>0)
            return true;
        else
            return false;
    }
}
