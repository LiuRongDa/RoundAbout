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

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getStaffPwd() {
        return staffPwd;
    }

    public void setStaffPwd(String staffPwd) {
        this.staffPwd = staffPwd;
    }

    public Integer getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(Integer staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffIdcard() {
        return staffIdcard;
    }

    public void setStaffIdcard(String staffIdcard) {
        this.staffIdcard = staffIdcard;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public Date getStaffIn() {
        return staffIn;
    }

    public void setStaffIn(Date staffIn) {
        this.staffIn = staffIn;
    }

    public Date getStaffOut() {
        return staffOut;
    }

    public void setStaffOut(Date staffOut) {
        this.staffOut = staffOut;
    }

    public Integer getStaffState() {
        return staffState;
    }

    public void setStaffState(Integer staffState) {
        this.staffState = staffState;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserIsexpired() {
        return userIsexpired;
    }

    public void setUserIsexpired(Integer userIsexpired) {
        this.userIsexpired = userIsexpired;
    }

    public Integer getUserIslocked() {
        return userIslocked;
    }

    public void setUserIslocked(Integer userIslocked) {
        this.userIslocked = userIslocked;
    }

    public Integer getUserIscreexpired() {
        return userIscreexpired;
    }

    public void setUserIscreexpired(Integer userIscreexpired) {
        this.userIscreexpired = userIscreexpired;
    }

    public Integer getUserIsenable() {
        return userIsenable;
    }

    public void setUserIsenable(Integer userIsenable) {
        this.userIsenable = userIsenable;
    }

    public List<GrantedAuthority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<GrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.getStaffPwd();
    }

    @Override
    public String getUsername() {
        return this.getStaffNumber();
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

    @Override
    public String toString() {
        return "TbStaff{" +
                "staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffNumber='" + staffNumber + '\'' +
                ", staffPwd='" + staffPwd + '\'' +
                ", staffSex=" + staffSex +
                ", staffIdcard='" + staffIdcard + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", staffIn=" + staffIn +
                ", staffOut=" + staffOut +
                ", staffState=" + staffState +
                ", roleId=" + roleId +
                ", userIsexpired=" + userIsexpired +
                ", userIslocked=" + userIslocked +
                ", userIscreexpired=" + userIscreexpired +
                ", userIsenable=" + userIsenable +
                ", authorityList=" + authorityList +
                '}';
    }
}