package com.aaa.controller;

import com.aaa.entity.TbUser;
import com.aaa.service.TbArticleService;
import com.aaa.service.TbIssueService;
import com.aaa.service.TbUserService;
import com.aaa.utils.EmailHelper;
import com.aaa.utils.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/User")
public class UserMessageController {
    @Resource
    TbUserService tbUserService;

    @Resource
    FileUtil fileUtil;

    @Resource
    TbArticleService tbArticleService;
    @Resource
    TbIssueService tbIssueService;

    //上传图片
    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadNew(HttpSession session,@RequestParam(value = "file" ,required = false) MultipartFile uploadFile){
        TbUser user = (TbUser) session.getAttribute("user");
        try {
            //检查是否是图片
            BufferedImage bi = ImageIO.read(uploadFile.getInputStream());
            if(bi == null){
                return null;
            }else{
                String upload = fileUtil.upload(uploadFile);
                if (tbUserService.setHeadImg(user.getUser_id(),upload))
                    return upload;
                else
                    return "error";
            }
        }catch (Exception e){
            return "error";
        }
    }
    //跳转到个人主页
    @RequestMapping("/toOneHome")
    public String toOneHome(HttpSession session,Model model){
        Integer id = (Integer) session.getAttribute("id");
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
        if (id==session.getAttribute("id")){
            return "redirect:toOneHome";
        }else{
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
