package com.fxb.learn.feign.entity.User;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/26
 *
 *      练习Feign
 */
public class User {
    private String id;
    private String username;
    
    public User(){}
    public User(String didi, String s) {
        this.username = didi;
        this.id = s;
    }
    
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
