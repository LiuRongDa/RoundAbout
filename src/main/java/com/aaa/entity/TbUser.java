package com.aaa.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "roundabout..tb_user")
public class TbUser {
    @Id
    @Column(name = "user_id")
    private Integer userId;

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

    @Column(name = "trade_id")
    private Integer tradeId;

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

    @Column(name = "user_isexpired")
    private Integer userIsexpired;

    @Column(name = "user_islocked")
    private Integer userIslocked;

    @Column(name = "user_isCreExpired")
    private Integer userIscreexpired;

    @Column(name = "user_isenable")
    private Integer userIsenable;

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
     * @return trade_id
     */
    public Integer getTradeId() {
        return tradeId;
    }

    /**
     * @param tradeId
     */
    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
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

    /**
     * @return user_isexpired
     */
    public Integer getUserIsexpired() {
        return userIsexpired;
    }

    /**
     * @param userIsexpired
     */
    public void setUserIsexpired(Integer userIsexpired) {
        this.userIsexpired = userIsexpired;
    }

    /**
     * @return user_islocked
     */
    public Integer getUserIslocked() {
        return userIslocked;
    }

    /**
     * @param userIslocked
     */
    public void setUserIslocked(Integer userIslocked) {
        this.userIslocked = userIslocked;
    }

    /**
     * @return user_isCreExpired
     */
    public Integer getUserIscreexpired() {
        return userIscreexpired;
    }

    /**
     * @param userIscreexpired
     */
    public void setUserIscreexpired(Integer userIscreexpired) {
        this.userIscreexpired = userIscreexpired;
    }

    /**
     * @return user_isenable
     */
    public Integer getUserIsenable() {
        return userIsenable;
    }

    /**
     * @param userIsenable
     */
    public void setUserIsenable(Integer userIsenable) {
        this.userIsenable = userIsenable;
    }
}