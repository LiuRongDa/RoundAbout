package com.aaa.controller;

import com.aaa.entity.TbUser;
import com.aaa.security.BCryptPasswordEncoderRun;
import com.aaa.service.*;
import com.aaa.utils.EmailHelper;
import com.aaa.utils.FileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @author WH
 * @date 2020/8/31 19:48
 */
@Controller
@RequestMapping("/Reception/User")
public class UserMessageController {
    @Resource
    TbUserService tbUserService;
    @Resource
    FileUtil fileUtil;

    @Resource
    TbArticleService tbArticleService;
    @Resource
    TbIssueService tbIssueService;
    @Resource
    BCryptPasswordEncoderRun bCryptPasswordEncoderRun;
    @Resource
    TbTradeService tbTradeService;
    @Resource
    TbTopicService tbTopicService;

    //跳转到修改邮箱
    @RequestMapping("/toChangeEmail")
    public String toChangeEmail(){
        return "changeemail";
    }
    //跳转到修改密码
    @RequestMapping("/toChangePwd")
    public String toChangePwd(){
        return "changepwd";
    }
    //修改密码
    @RequestMapping("/changePwd")
    @ResponseBody
    public Integer changePwd(HttpSession session, @Param("oldpwd") String oldpwd,@Param("newpwd") String newpwd){
        TbUser user = (TbUser) session.getAttribute("user");
        System.out.println(oldpwd+"--"+newpwd);
        if(bCryptPasswordEncoderRun.passwordEncoder().matches(oldpwd,user.getUser_pwd())){
            if (tbUserService.setpwd(user.getUser_id(), newpwd)){
                return 1;
            }else
                return 2;
        }else
            return 0;
    }
    //上传图片
    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadNew(HttpSession session,@RequestParam(value = "file" ,required = false) MultipartFile uploadFile,@RequestParam(value = "sta" ,required = false) Integer sta){
        TbUser user = (TbUser) session.getAttribute("user");
        System.out.println(sta);
        if(sta==null)
            sta=0;
        try {
            //检查是否是图片
            BufferedImage bi = ImageIO.read(uploadFile.getInputStream());
            if(bi == null){
                return null;
            }else {
                String upload = fileUtil.upload(uploadFile);
                if (sta != 0) {
                    if (tbUserService.setbgImg(user.getUser_id(), upload)) {
                        session.setAttribute("user", tbUserService.queryById((Integer) session.getAttribute("id")));
                        return upload;
                    } else
                        return "error";
                } else {
                    if (tbUserService.setHeadImg(user.getUser_id(), upload)) {
                        session.setAttribute("user", tbUserService.queryById((Integer) session.getAttribute("id")));
                        return upload;
                    } else
                        return "error";
                }
            }
        }catch (Exception e){
            return "error";
        }
    }
    //跳转到个人主页
    @RequestMapping("/toOneHome")
    public String toOneHome(HttpSession session,Model model){
        Integer id = (Integer) session.getAttribute("id");
        //查询用户的专栏
        model.addAttribute("topic",tbTopicService.queryUser(id));
        //answer 查询用户回答的问题
        model.addAttribute("userAnswerIssue",tbIssueService.queryUserIssue(id));
        //查询用户的文章
        model.addAttribute("article",tbArticleService.queryUser(id));
        //查询关注的人
        model.addAttribute("userAttention",tbUserService.queryUserAttention(id));
        //查询用户被谁关注
        model.addAttribute("attentionUser",tbUserService.queryAttentionUser(id));
        //用户的问题
        model.addAttribute("userIssue",tbIssueService.userIssue(id));

        return "onehome";
    }
    //关注 取消
    @RequestMapping("/attention")
    @ResponseBody
    public String attention(HttpSession session,Integer id,Integer sta){
        System.out.println(sta);
        tbUserService.attention((Integer) session.getAttribute("id"),id,sta);
        return null;
    }
    //跳转到别人主页
    @RequestMapping("/toElseHome")
    public String toElseHome(HttpSession session,Integer id,Model model){
        //System.out.println(session.getAttribute("id")+"---"+id);
        Integer userId = (Integer) session.getAttribute("id");
        if (id.equals(userId)){
            return "redirect:toOneHome";
        }else{
            //查询用户的专栏
            model.addAttribute("topic",tbTopicService.queryUser(id));
            //主页浏览次数增加
            tbUserService.addcount(id);
            //answer 查询用户回答的问题
            model.addAttribute("userAnswerIssue",tbIssueService.queryUserIssue(id));
            //查询是否关注某人
            model.addAttribute("booleanUser",tbUserService.booleanUser((Integer) session.getAttribute("id"),id));
            //基本信息
            model.addAttribute("elseUser",tbUserService.queryById(id));
            //查询用户的文章
            model.addAttribute("article",tbArticleService.queryUser(id));
            //查询关注的人
            model.addAttribute("userAttention",tbUserService.queryUserAttention(id));
            //查询用户被谁关注
            model.addAttribute("attentionUser",tbUserService.queryAttentionUser(id));
            //用户的问题
            model.addAttribute("userIssue",tbIssueService.userIssue(id));
            return "else_userhome";
        }
    }

    //跳转到个人信息编辑页面
    @RequestMapping("/toMessage")
    public String toMessage(Model model){
        model.addAttribute("trade",tbTradeService.queryAll());
        return "onemessage";
    }

    //忘记密码 查询邮箱是否存在
    @RequestMapping("/byEmail")
    @ResponseBody
    public String byemail(@RequestParam("email") String email,@RequestParam("sta") Integer sta){
        //sta=1 邮箱存在发送验证码   sta=0 邮箱不存在发送验证码
        TbUser byemail = tbUserService.byemail(email);
        System.out.println(byemail);
        if (byemail!=null) {
            if (sta!=0) {
                String random = String.valueOf(Math.round(Math.random() * 1000000));
                EmailHelper.sendEmail(email, random);
                String data = byemail.getUser_id() + "_" + random;
                System.out.println(data);
                return data;
            }else
                return null;
        }else {
            if(sta!=1){
                String data =String.valueOf(Math.round(Math.random() * 1000000));
                EmailHelper.sendEmail(email,data);
                return data;
            }else
                return null;
        }
    }

    //忘记密码 设置密码
    @RequestMapping("/setpwd")
    @ResponseBody
    public boolean setpwd(@RequestParam("id") int id,@RequestParam("pwd") String pwd){

        return tbUserService.setpwd(id, pwd);
    }
    //修改密码
    @RequestMapping("/setEmail")
    @ResponseBody
    public boolean setEmail(HttpSession session,@RequestParam("email") String email){
        Integer id = (Integer) session.getAttribute("id");
        return tbUserService.setEmail(session,id,email);
    }

    //修改个人信息
    @RequestMapping(value = "/setUser", method = RequestMethod.POST)
    public String setUser(TbUser user,HttpSession session){
        //System.out.println(user);
        user.setUser_id((Integer) session.getAttribute("id"));
        boolean b = tbUserService.setUser(user);
        if (b) {
            session.setAttribute("user",tbUserService.queryById((Integer) session.getAttribute("id")));
            return "redirect:toOneHome";
        }else
            return "";

    }
}
