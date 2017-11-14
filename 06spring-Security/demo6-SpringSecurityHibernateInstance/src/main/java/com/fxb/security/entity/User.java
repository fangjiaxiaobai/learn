package com.fxb.security.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fangxiaobai
 * @date 2017/11/12 15:52.
 * @description User
 */
@Entity
@Table(name="t_user")
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotEmpty
    @Column(name = "username",unique = true,nullable = false)
    private String username;
    @NotEmpty
    @Column(name = "password",unique = true,nullable = false)
    private String password;
    @NotEmpty
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @NotEmpty
    @Column(name = "state",nullable = false)
    private String state = "ACTIVE";
    
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_user_role",joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet <Role>();
    
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public Set <Role> getRoles() {
        return roles;
    }
    
    public void setRoles(Set <Role> roles) {
        this.roles = roles;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
