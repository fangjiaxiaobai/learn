package com.fxb.redisLearn.entity;

/**
 * @author fangxiaobai on 2017/11/2 16:46.
 * @description
 */
public class User {
    private String id;
    private String username;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
