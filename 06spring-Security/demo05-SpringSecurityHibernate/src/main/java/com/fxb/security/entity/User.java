package com.fxb.security.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fangxiaobai
 * @date 2017/11/8 21:18.
 * @description User
 */

@Entity
@Table(name = "t_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", unique = true, nullable = false)
    private String password;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name="state")
    private String state;
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_user_profile",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name="profile_id")})
    private Set<UserProfile> userProfiles = new HashSet <UserProfile>();
    
    private String getId() {
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            return id.equals(((User) obj).getId());
        }
        return false;
    }
    
    public Set <UserProfile> getUserProfiles() {
        return userProfiles;
    }
    
    public void setUserProfiles(Set <UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }
}
