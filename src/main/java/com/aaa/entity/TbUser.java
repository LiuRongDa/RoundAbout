package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class TbUser {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_photo")
    private String userPhoto;

    @Column(name = "user_backdrop")
    private String userBackdrop;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_sex")
    private Integer userSex;

    @Column(name = "user_sign")
    private String userSign;

    @Column(name = "user_residence")
    private String userResidence;

    @Column(name = "user_trade")
    private String userTrade;

    @Column(name = "user_brief")
    private String userBrief;

    @Column(name = "user_balance")
    private Double userBalance;

    @Column(name = "user_count")
    private Integer userCount;

    @Column(name = "user_joindate")
    private Date userJoindate;

    @Column(name = "user_state")
    private Integer userState;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_photo
     */
    public String getUserPhoto() {
        return userPhoto;
    }

    /**
     * @param userPhoto
     */
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    /**
     * @return user_backdrop
     */
    public String getUserBackdrop() {
        return userBackdrop;
    }

    /**
     * @param userBackdrop
     */
    public void setUserBackdrop(String userBackdrop) {
        this.userBackdrop = userBackdrop;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_pwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * @return user_sex
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * @param userSex
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * @return user_sign
     */
    public String getUserSign() {
        return userSign;
    }

    /**
     * @param userSign
     */
    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    /**
     * @return user_residence
     */
    public String getUserResidence() {
        return userResidence;
    }

    /**
     * @param userResidence
     */
    public void setUserResidence(String userResidence) {
        this.userResidence = userResidence;
    }

    /**
     * @return user_trade
     */
    public String getUserTrade() {
        return userTrade;
    }

    /**
     * @param userTrade
     */
    public void setUserTrade(String userTrade) {
        this.userTrade = userTrade;
    }

    /**
     * @return user_brief
     */
    public String getUserBrief() {
        return userBrief;
    }

    /**
     * @param userBrief
     */
    public void setUserBrief(String userBrief) {
        this.userBrief = userBrief;
    }

    /**
     * @return user_balance
     */
    public Double getUserBalance() {
        return userBalance;
    }

    /**
     * @param userBalance
     */
    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    /**
     * @return user_count
     */
    public Integer getUserCount() {
        return userCount;
    }

    /**
     * @param userCount
     */
    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    /**
     * @return user_joindate
     */
    public Date getUserJoindate() {
        return userJoindate;
    }

    /**
     * @param userJoindate
     */
    public void setUserJoindate(Date userJoindate) {
        this.userJoindate = userJoindate;
    }

    /**
     * @return user_state
     */
    public Integer getUserState() {
        return userState;
    }

    /**
     * @param userState
     */
    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}