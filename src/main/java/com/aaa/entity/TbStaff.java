package com.aaa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_staff")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbStaff implements Serializable, UserDetails {
    @Id
    private Integer staff_id;

    private String staff_name;

    private String staff_number;

    private String staff_pwd;

    private Integer staff_sex;

    private String staff_idcard;

    private String staff_phone;

    private Date staff_in;

    private Date staff_out;

    private Integer staff_state;

    private Integer role_id;

    private Integer user_isexpired;

    private Integer user_islocked;

    @Column(name = "user_isCreExpired")
    private Integer user_isCreExpired;

    private Integer user_isenable;

    private List<GrantedAuthority> authorityList;//权限信息

    private TbRole tbRole;//角色

    private static final long serialVersionUID = 1L;


    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_number() {
        return staff_number;
    }

    public void setStaff_number(String staff_number) {
        this.staff_number = staff_number;
    }

    public String getStaff_pwd() {
        return staff_pwd;
    }

    public void setStaff_pwd(String staff_pwd) {
        this.staff_pwd = staff_pwd;
    }

    public Integer getStaff_sex() {
        return staff_sex;
    }

    public void setStaff_sex(Integer staff_sex) {
        this.staff_sex = staff_sex;
    }

    public String getStaff_idcard() {
        return staff_idcard;
    }

    public void setStaff_idcard(String staff_idcard) {
        this.staff_idcard = staff_idcard;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    public Date getStaff_in() {
        return staff_in;
    }

    public void setStaff_in(Date staff_in) {
        this.staff_in = staff_in;
    }

    public Date getStaff_out() {
        return staff_out;
    }

    public void setStaff_out(Date staff_out) {
        this.staff_out = staff_out;
    }

    public Integer getStaff_state() {
        return staff_state;
    }

    public void setStaff_state(Integer staff_state) {
        this.staff_state = staff_state;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getUser_isexpired() {
        return user_isexpired;
    }

    public void setUser_isexpired(Integer user_isexpired) {
        this.user_isexpired = user_isexpired;
    }

    public Integer getUser_islocked() {
        return user_islocked;
    }

    public void setUser_islocked(Integer user_islocked) {
        this.user_islocked = user_islocked;
    }

    public Integer getUser_isCreExpired() {
        return user_isCreExpired;
    }

    public void setUser_isCreExpired(Integer user_isCreExpired) {
        this.user_isCreExpired = user_isCreExpired;
    }

    public Integer getUser_isenable() {
        return user_isenable;
    }

    public void setUser_isenable(Integer user_isenable) {
        this.user_isenable = user_isenable;
    }

    public List<GrantedAuthority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<GrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }

    public TbRole getTbRole() {
        return tbRole;
    }

    public void setTbRole(TbRole tbRole) {
        this.tbRole = tbRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.staff_pwd;
    }

    @Override
    public String getUsername() {
        return this.staff_number;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.user_isexpired==1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.user_islocked==1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.user_isexpired==1;
    }

    @Override
    public boolean isEnabled() {
        return this.user_isenable==1;
    }

    @Override
    public String toString() {
        return "TbStaff{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", staff_number='" + staff_number + '\'' +
                ", staff_pwd='" + staff_pwd + '\'' +
                ", staff_sex=" + staff_sex +
                ", staff_idcard='" + staff_idcard + '\'' +
                ", staff_phone='" + staff_phone + '\'' +
                ", staff_in=" + staff_in +
                ", staff_out=" + staff_out +
                ", staff_state=" + staff_state +
                ", role_id=" + role_id +
                ", user_isexpired=" + user_isexpired +
                ", user_islocked=" + user_islocked +
                ", user_isCreExpired=" + user_isCreExpired +
                ", user_isenable=" + user_isenable +
                ", authorityList=" + authorityList +
                ", tbRole=" + tbRole +
                '}';
    }
}