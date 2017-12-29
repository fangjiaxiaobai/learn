package com.fxb.learn.chapter5hystrix.entity;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/21
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
}
