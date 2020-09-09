package com.aaa.service;

import com.aaa.dao.TbAttentionMapper;
import com.aaa.dao.TbEducationMapper;
import com.aaa.dao.TbProfessionMapper;
import com.aaa.dao.TbUserMapper;
import com.aaa.entity.TbAttention;
import com.aaa.entity.TbUser;
import com.aaa.security.BCryptPasswordEncoderRun;
import com.aaa.utils.EmailSendUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/8/24 14:10
 */
@Service
public class TbUserService {
    @Resource
    TbUserMapper tbUserMapper;

    @Resource
    TbProfessionMapper tbProfessionMapper;

    @Resource
    TbEducationMapper tbEducationMapper;

    @Resource
    EmailSendUtils emailSendUtils;

    @Resource
    BCryptPasswordEncoderRun bCryptPasswordEncoderRun;
    @Resource
    TbAttentionMapper tbAttentionMapper;//关注表

    /**
     * 查询随机5条用户
     * @return
     */
    public List<TbUser> queryround(){
        List<TbUser> queryround = tbUserMapper.queryround();
        return queryround;
    }

    //修改个人信息
    public boolean setUser(TbUser user){
        int i = tbUserMapper.updateByPrimaryKeySelective(user);
        if (1>0)
            return true;
        else
            return false;
    }
    //主页访问次数+1
    public void addcount(Integer id){
        TbUser tbUser = queryById(id);
        TbUser tbUser1 = new TbUser();
        tbUser1.setUser_id(id);
        tbUser1.setUser_count(tbUser.getUser_count()+1);
        tbUserMapper.updateByPrimaryKeySelective(tbUser1);
    }
    //关注 取消
    public void attention(Integer id,Integer id1,Integer sta){
        TbAttention tbAttention = new TbAttention();
        tbAttention.setUser_id(id);
        tbAttention.setUser_idl(id1);
        if (sta!=0) {
            System.out.println(1);//取消关注
            System.out.println(tbAttentionMapper.delete(tbAttention));
        }else {//关注
            System.out.println(tbAttentionMapper.insert(tbAttention));
        }
    }
    //查询是否关注了某人
    public boolean booleanUser(Integer id,Integer idl){
        TbAttention tbAttention = new TbAttention();
        tbAttention.setUser_id(id);
        tbAttention.setUser_idl(idl);
        List<TbAttention> select = tbAttentionMapper.select(tbAttention);
        if (select.size()!=0){
            return true;
        }else
            return false;
    }
    //查询被谁关注
    public List<TbUser> queryAttentionUser(Integer user_id){
        List<TbUser> tbUsers = tbUserMapper.queryAttentionUser(user_id);
        return tbUsers;
    }
    //查询关注的人
    public List<TbUser> queryUserAttention(Integer user_id){
        List<TbUser> tbUsers = tbUserMapper.queryUserAttention(user_id);
        return tbUsers;
    }

    //设置背景图
    public boolean setbgImg(Integer id,String image){
        TbUser tbUser = new TbUser();
        tbUser.setUser_id(id);
        tbUser.setUser_backdrop(image);
        int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
        if (i>0)
            return true;
        else
            return false;
    }
    //设置头像
    public boolean setHeadImg(Integer id,String image){
        TbUser tbUser = new TbUser();
        tbUser.setUser_id(id);
        tbUser.setUser_photo(image);
        int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
        if (i>0)
            return true;
        else
            return false;
    }

    //注册
    public int toRegister(String email,String pwd){
        TbUser tbUser = new TbUser();
        tbUser.setUser_email(email);
        tbUser.setUser_name("zh"+Math.random()*10000);
        tbUser.setUser_state(0);
        tbUser.setUser_joindate(new Date());
        tbUser.setUser_pwd(bCryptPasswordEncoderRun.passwordEncoder().encode(pwd));
        int insert = tbUserMapper.insert(tbUser);
        return insert;
    }
    /**
     * wh
     * 登录
     */
    public TbUser toLogin(String email,String pwd){
        TbUser tbUser = new TbUser();
        if (email.contains("@"))
            tbUser.setUser_email(email);
        else
            tbUser.setUser_phone(email);
        TbUser tbUser1 = tbUserMapper.selectOne(tbUser);
        boolean matches = bCryptPasswordEncoderRun.passwordEncoder().matches(pwd, tbUser1.getUser_pwd());
        if (matches)
            return tbUser1;
        else
            return null;
    }
    //查询邮箱是否存在
    public TbUser byemail(String email){
        TbUser tbUser = new TbUser();
        tbUser.setUser_email(email);
        return tbUserMapper.selectOne(tbUser);
    }
    //设置密码
    public boolean setpwd(int id, String pwd){
        TbUser tbUser = new TbUser();
        tbUser.setUser_id(id);
        tbUser.setUser_pwd(bCryptPasswordEncoderRun.passwordEncoder().encode(pwd));
        int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
        if (i>0)
            return true;
        else
            return false;
    }
    //设置密码
    public boolean setEmail(HttpSession session,Integer id, String email){
        TbUser tbUser = new TbUser();
        tbUser.setUser_id(id);
        tbUser.setUser_email(email);
        int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
        if (i>0) {
            session.setAttribute("user",tbUserMapper.selectByPrimaryKey(tbUser));
            return true;
        }else
            return false;
    }

    /**
     * 关联 trade 表 分页 +模糊搜索
     * @return
     */
    public PageInfo<TbUser> selePage(Integer pageNum,Integer pageSize,String user_name){
        if(pageNum==null || pageNum==0){
            PageHelper.startPage(1,5);
        }else if(pageSize==null || pageSize==0){
            PageHelper.startPage(pageNum,5);
        }else{
            PageHelper.startPage(pageNum,pageSize);
        }
        List<TbUser> tbUsers = tbUserMapper.userAndTradeQueryAll(user_name);
        System.out.println(tbUsers);
        PageInfo<TbUser> pageInfo=new PageInfo<>(tbUsers);
        System.out.println(pageInfo);
        return pageInfo;
    }

    /**
     *  LRD  后台添加
     * @param tbUser
     * @return
     */
    public Boolean add(TbUser tbUser){
        //加密
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String pwd = bCrypt.encode(tbUser.getUser_pwd());
        tbUser.setUser_pwd(pwd);
        tbUser.setUser_photo("cat.gif");
        Boolean add = tbUserMapper.add(tbUser);
        return add;
    }

    /**
     * LRD 后台 修改状态
     * @param user_state
     * @param user_id
     * @return
     */
    public Boolean upState(Integer user_state,Integer user_id){
        Boolean aBoolean = tbUserMapper.upState(user_state, user_id);
        sendEmail(user_state,user_id);//调用发送邮件的方法
        return aBoolean;
    }

    //发送邮件
    public void sendEmail(Integer user_state,Integer user_id){
        TbUser tbUser=new TbUser();
        tbUser.setUser_id(user_id);
        TbUser user = tbUserMapper.selectOne(tbUser);
        if(user_state==0){
            emailSendUtils.sendSimple("大问号","您的账户已被封禁！",user.getUser_email());
        }else{
            emailSendUtils.sendSimple("大问号","您的账户已被解封！",user.getUser_email());
        }
    }

    /**
     * LRD 后台 查询全部用户
     * @return
     */
    public List<TbUser> queryAll(){
        return tbUserMapper.selectAll();
    }

    /**
     * LRD 后台 查询单个用户  查询被举报人
     * @param user_id
     * @return
     */
    public TbUser queryById(Integer user_id){
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(user_id);
        return tbUser;
    }


    public TbUser queryByUserId(Integer user_id){
        TbUser tbUser=new TbUser();
        tbUser.setUser_id(user_id);
        TbUser selectOne = tbUserMapper.selectOne(tbUser);
        return selectOne;
    }
}
