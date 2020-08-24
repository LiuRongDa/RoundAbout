package com.aaa.entity;

import javax.persistence.*;

@Table(name = "roundabout..tb_role_power")
public class TbRolePower {
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "power_id")
    private Integer powerId;

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
     * @return power_id
     */
    public Integer getPowerId() {
        return powerId;
    }

    /**
     * @param powerId
     */
    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }
}