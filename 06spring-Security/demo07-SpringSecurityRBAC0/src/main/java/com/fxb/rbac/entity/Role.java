package com.fxb.rbac.entity;

import com.fxb.rbac.common.Entity;

/**
 * @author fangxiaobai
 * @date 2017/11/15 13:12.
 * @description Role
 */
public class Role extends Entity{
    
    private String role;
    private String status;
    private String remarks;
    
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
