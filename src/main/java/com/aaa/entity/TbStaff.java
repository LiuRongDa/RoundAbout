package com.aaa.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_staff")
public class TbStaff implements UserDetails {
    @Id
    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_number")
    private String staffNumber;

    @Column(name = "staff_pwd")
    private String staffPwd;

    @Column(name = "staff_sex")
    private Integer staffSex;

    @Column(name = "staff_idcard")
    private String staffIdcard;

    @Column(name = "staff_phone")
    private String staffPhone;

    @Column(name = "staff_in")
    private Date staffIn;

    @Column(name = "staff_out")
    private Date staffOut;

    @Column(name = "staff_state")
    private Integer staffState;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "user_isexpired")
    private Integer userIsexpired;

    @Column(name = "user_islocked")
    private Integer userIslocked;

    @Column(name = "user_isCreExpired")
    private Integer userIscreexpired;

    @Column(name = "user_isenable")
    private Integer userIsenable;

    private List<GrantedAuthority> authorityList;//权限信息

    public List<GrantedAuthority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<GrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }

    /**
     * @return staff_id
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * @param staffId
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * @return staff_name
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @param staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * @return staff_number
     */
    public String getStaffNumber() {
        return staffNumber;
    }

    /**
     * @param staffNumber
     */
    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    /**
     * @return staff_pwd
     */
    public String getStaffPwd() {
        return staffPwd;
    }

    /**
     * @param staffPwd
     */
    public void setStaffPwd(String staffPwd) {
        this.staffPwd = staffPwd;
    }

    /**
     * @return staff_sex
     */
    public Integer getStaffSex() {
        return staffSex;
    }

    /**
     * @param staffSex
     */
    public void setStaffSex(Integer staffSex) {
        this.staffSex = staffSex;
    }

    /**
     * @return staff_idcard
     */
    public String getStaffIdcard() {
        return staffIdcard;
    }

    /**
     * @param staffIdcard
     */
    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard;
    }

    /**
     * @return staff_phone
     */
    public String getStaffPhone() {
        return staffPhone;
    }

    /**
     * @param staffPhone
     */
    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    /**
     * @return staff_in
     */
    public Date getStaffIn() {
        return staffIn;
    }

    /**
     * @param staffIn
     */
    public void setStaffIn(Date staffIn) {
        this.staffIn = staffIn;
    }

    /**
     * @return staff_out
     */
    public Date getStaffOut() {
        return staffOut;
    }

    /**
     * @param staffOut
     */
    public void setStaffOut(Date staffOut) {
        this.staffOut = staffOut;
    }

    /**
     * @return staff_state
     */
    public Integer getStaffState() {
        return staffState;
    }

    /**
     * @param staffState
     */
    public void setStaffState(Integer staffState) {
        this.staffState = staffState;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public String getUsername() {
        return this.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.userIsexpired==1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.userIslocked==1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.userIscreexpired==1;
    }

    @Override
    public boolean isEnabled() {
        return this.userIsenable==1;
    }
}