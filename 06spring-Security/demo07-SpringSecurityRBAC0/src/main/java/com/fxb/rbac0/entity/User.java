package com.fxb.rbac0.entity;

import com.fxb.rbac0.common.Entity;

/**
 * @author fangxiaobai
 * @date 2017/11/15 11:49.
 * @description User
 */
public class User extends Entity{
    
    private String username;
    private String password;
    private String status;
    private String salt;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getSalt() {
        return salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
    
}
