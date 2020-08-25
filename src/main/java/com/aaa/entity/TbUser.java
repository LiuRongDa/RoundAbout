package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "tb_user")
public class TbUser implements Serializable {
    @Id
    private Integer user_id;

    private String user_name;

    private String user_photo;

    private String user_backdrop;

    private String user_phone;

    private String user_email;

    private String user_pwd;

    private Integer user_sex;

    private String user_sign;

    private String user_residence;

    private String user_trade;

    private String user_brief;

    private Double user_balance;

    private Integer user_count;

    private Date user_joindate;

    private Integer user_state;


    private List<TbProfession> tbProfessionList;

    private List<TbEducation> tbEducations;


    private static final long serialVersionUID = 1L;

    public List<TbProfession> getTbProfessionList() {
        return tbProfessionList;
    }

    public void setTbProfessionList(List<TbProfession> tbProfessionList) {
        this.tbProfessionList = tbProfessionList;
    }

    public List<TbEducation> getTbEducations() {
        return tbEducations;
    }

    public void setTbEducations(List<TbEducation> tbEducations) {
        this.tbEducations = tbEducations;
    }

    /**
     * @return user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * @return user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return user_photo
     */
    public String getUser_photo() {
        return user_photo;
    }

    /**
     * @param user_photo
     */
    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    /**
     * @return user_backdrop
     */
    public String getUser_backdrop() {
        return user_backdrop;
    }

    /**
     * @param user_backdrop
     */
    public void setUser_backdrop(String user_backdrop) {
        this.user_backdrop = user_backdrop;
    }

    /**
     * @return user_phone
     */
    public String getUser_phone() {
        return user_phone;
    }

    /**
     * @param user_phone
     */
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    /**
     * @return user_email
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * @param user_email
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * @return user_pwd
     */
    public String getUser_pwd() {
        return user_pwd;
    }

    /**
     * @param user_pwd
     */
    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    /**
     * @return user_sex
     */
    public Integer getUser_sex() {
        return user_sex;
    }

    /**
     * @param user_sex
     */
    public void setUser_sex(Integer user_sex) {
        this.user_sex = user_sex;
    }

    /**
     * @return user_sign
     */
    public String getUser_sign() {
        return user_sign;
    }

    /**
     * @param user_sign
     */
    public void setUser_sign(String user_sign) {
        this.user_sign = user_sign;
    }

    /**
     * @return user_residence
     */
    public String getUser_residence() {
        return user_residence;
    }

    /**
     * @param user_residence
     */
    public void setUser_residence(String user_residence) {
        this.user_residence = user_residence;
    }

    /**
     * @return user_trade
     */
    public String getUser_trade() {
        return user_trade;
    }

    /**
     * @param user_trade
     */
    public void setUser_trade(String user_trade) {
        this.user_trade = user_trade;
    }

    /**
     * @return user_brief
     */
    public String getUser_brief() {
        return user_brief;
    }

    /**
     * @param user_brief
     */
    public void setUser_brief(String user_brief) {
        this.user_brief = user_brief;
    }

    /**
     * @return user_balance
     */
    public Double getUser_balance() {
        return user_balance;
    }

    /**
     * @param user_balance
     */
    public void setUser_balance(Double user_balance) {
        this.user_balance = user_balance;
    }

    /**
     * @return user_count
     */
    public Integer getUser_count() {
        return user_count;
    }

    /**
     * @param user_count
     */
    public void setUser_count(Integer user_count) {
        this.user_count = user_count;
    }

    /**
     * @return user_joindate
     */
    public Date getUser_joindate() {
        return user_joindate;
    }

    /**
     * @param user_joindate
     */
    public void setUser_joindate(Date user_joindate) {
        this.user_joindate = user_joindate;
    }

    /**
     * @return user_state
     */
    public Integer getUser_state() {
        return user_state;
    }

    /**
     * @param user_state
     */
    public void setUser_state(Integer user_state) {
        this.user_state = user_state;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_photo='" + user_photo + '\'' +
                ", user_backdrop='" + user_backdrop + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_sex=" + user_sex +
                ", user_sign='" + user_sign + '\'' +
                ", user_residence='" + user_residence + '\'' +
                ", user_trade='" + user_trade + '\'' +
                ", user_brief='" + user_brief + '\'' +
                ", user_balance=" + user_balance +
                ", user_count=" + user_count +
                ", user_joindate=" + user_joindate +
                ", user_state=" + user_state +
                ", tbProfessionList=" + tbProfessionList +
                ", tbEducations=" + tbEducations +
                '}';
    }
}