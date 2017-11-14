package com.fxb.security.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author fangxiaobai
 * @date 2017/11/12 15:18.z
 * @description PersistentLogin
 */

@Entity
@Table(name = "t_persistent_logins")
public class PersistentLogin implements Serializable {
    
    @Id
    private String id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "token", unique = true, nullable = false)
    private String token;
    @Column(name = "last_used")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUsed;
    
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
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public Date getLastUsed() {
        return lastUsed;
    }
    
    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
}
