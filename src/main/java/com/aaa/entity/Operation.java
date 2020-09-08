package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "operation")
public class Operation implements Serializable {
    @Id
    private Integer operation_id;

    private String operation_content;

    private Date operation_time;

    private Integer staff_id;

    private Integer user_id;

    private String user_name;

    private TbUser tbUser;

    private TbStaff tbStaff;

    private static final long serialVersionUID = 1L;

    /**
     * @return operation_id
     */
    public Integer getOperation_id() {
        return operation_id;
    }

    /**
     * @param operation_id
     */
    public void setOperation_id(Integer operation_id) {
        this.operation_id = operation_id;
    }

    /**
     * @return operation_content
     */
    public String getOperation_content() {
        return operation_content;
    }

    /**
     * @param operation_content
     */
    public void setOperation_content(String operation_content) {
        this.operation_content = operation_content;
    }

    /**
     * @return operation_time
     */
    public Date getOperation_time() {
        return operation_time;
    }

    /**
     * @param operation_time
     */
    public void setOperation_time(Date operation_time) {
        this.operation_time = operation_time;
    }

    /**
     * @return staff_id
     */
    public Integer getStaff_id() {
        return staff_id;
    }

    /**
     * @param staff_id
     */
    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
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

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public TbStaff getTbStaff() {
        return tbStaff;
    }

    public void setTbStaff(TbStaff tbStaff) {
        this.tbStaff = tbStaff;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operation_id=" + operation_id +
                ", operation_content='" + operation_content + '\'' +
                ", operation_time=" + operation_time +
                ", staff_id=" + staff_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", tbUser=" + tbUser +
                ", tbStaff=" + tbStaff +
                '}';
    }
}