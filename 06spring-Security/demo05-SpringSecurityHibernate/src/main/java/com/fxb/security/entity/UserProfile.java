package com.fxb.security.entity;

import javax.persistence.*;

/**
 * @author fangxiaobai
 * @date 2017/11/8 21:27.
 * @description UserProfile
 */

@Entity
@Table(name = "t_user_profile")
public class UserProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @Column(name = "type", length = 15, unique = true, nullable = false)
    private String type = UserProfileType.USER.getUserProfileType();
    
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
