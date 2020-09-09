package com.aaa.service;

import com.aaa.dao.*;
import com.aaa.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: LRD
 * @time: 2020/9/3 9:00
 */
@Service
public class TbReportService {
    @Resource
    TbReportMapper tbReportMapper;

    @Resource
    TbCommentService tbCommentService;

    @Resource
    TbArticleService tbArticleService;

    @Resource
    TbIssueService tbIssueService;

    @Resource
    TbIssueMapper tbIssueMapper;

    @Resource
    TbArticleMapper tbArticleMapper;

    @Resource
    TbCommentMapper tbCommentMapper;

    @Resource
    TbReplyMapper tbReplyMapper;

    @Resource
    TbIssueArticleMapper tbIssueArticleMapper;

    /**
     * 举报文章
     * @param article_id
     * @param user_id
     * @param report_content
     * @return
     */
    public Integer reportArticle(Integer article_id,Integer user_id,String report_content){
        TbReport tbReport = new TbReport();
        tbReport.setArticle_id(article_id);
        tbReport.setUser_id(user_id);
        tbReport.setReport_content(report_content);

        List<TbReport> select = tbReportMapper.select(tbReport);
        if(select.size() != 0){
            tbReport.setReport_data(new Date());
            int insert = tbReportMapper.insert(tbReport);
            return 1;
        }
        return 0;
    }

    /**
     * LRD  后台  分页+模糊查询
     *
     * @param pageNum
     * @param pageSize
     * @param report_content
     * @param report_data
     * @return
     */
    public PageInfo<TbReport> selePage(Integer pageNum, Integer pageSize, String report_content, String report_data, Integer report_id, Integer bereport_user_id) {
        if (pageNum == null || pageNum == 0) pageNum = 1;
        if (pageSize == null || pageSize == 0) pageSize = 10;
        PageHelper.startPage(pageNum, pageSize);
        List<TbReport> tbReports = tbReportMapper.selePage(report_content, report_data, report_id, bereport_user_id);
        PageInfo<TbReport> pageInfo = new PageInfo<>(tbReports);
        return pageInfo;
    }

    /**
     * LRD 后台 查看详情
     *
     * @param report_id
     * @return
     */
    public List<TbReport> showMore(Integer report_id, Integer bereport_user_id) {
        List<TbReport> tbReports = tbReportMapper.selePage(null, null, report_id, bereport_user_id);
        return tbReports;
    }

    //问题
    public Boolean delIssue(Integer Issue_id){
        TbIssueArticle tbIssueArticle = new TbIssueArticle();
        tbIssueArticle.setIssue_id(Issue_id);
        List<TbIssueArticle> tbIssueArticleList = tbIssueArticleMapper.select(tbIssueArticle);
        for (TbIssueArticle tbissue :tbIssueArticleList) {
            delArticle(tbissue.getArticle_id());
        }
        tbIssueArticleMapper.delete(tbIssueArticle);

        int i = tbIssueMapper.deleteByPrimaryKey(Issue_id);
        if(i==1)return true;
        return false;
    }
    //文章
    public void delArticle(Integer Article_id){
        TbComment tbComment=new TbComment();
        tbComment.setArticle_id(Article_id);
        List<TbComment> tbCommentList = tbCommentMapper.select(tbComment);
        for (TbComment tbcomm :tbCommentList) {
            delComment(tbcomm.getComment_id());
        }
        tbArticleMapper.deleteByPrimaryKey(Article_id);
    }
    //评论
    public void delComment(Integer Comment_id){
        TbReply tbReply=new TbReply();
        tbReply.setComment_id(Comment_id);
        List<TbReply> tbReplyList = tbReplyMapper.select(tbReply);
        for (TbReply reply: tbReplyList) {
            tbReplyMapper.deleteByPrimaryKey(reply.getReply_id());
        }
        tbCommentMapper.deleteByPrimaryKey(Comment_id);
    }
    //回复
    public void delReply(Integer Reply_id){
        tbReplyMapper.deleteByPrimaryKey(Reply_id);
    }

    /**
     * 删除
     *
     * @param report_id
     * @return
     */
    //事务
    @Transactional
    public Boolean del(Integer report_id) {
        List<TbReport> tbReports = tbReportMapper.selePage(null, null, report_id, null);
        //删除问题
        if(tbReports.get(0).getIssue_id()!=null){
            delIssue(tbReports.get(0).getIssue_id());
            delReport(report_id);
            return true;
        }
        //删除文章
        if(tbReports.get(0).getArticle_id()!=null){
            delArticle(tbReports.get(0).getArticle_id());
            delReport(report_id);
            return true;
        }
        //删除评论
        if(tbReports.get(0).getComment_id()!=null){
            delComment(tbReports.get(0).getComment_id());
            delReport(report_id);
            return true;
        }
        //删除回复
        if(tbReports.get(0).getReply_id()!=null){
            delReply(tbReports.get(0).getReply_id());
            delReport(report_id);
            return true;
        }
        return delReport(report_id);
    }

    /**
     * 删除举报记录
     * @param report_id
     * @return
     */
    public Boolean delReport(Integer report_id){
        int i = tbReportMapper.deleteByPrimaryKey(report_id);
        if(i!= 0)return true;
        return false;
    }
}
