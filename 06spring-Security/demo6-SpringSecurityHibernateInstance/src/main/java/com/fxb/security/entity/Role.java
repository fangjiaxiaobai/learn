package com.fxb.security.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fangxiaobai
 * @date 2017/11/12 15:55.
 * @description Role
 */
@Entity
@Table(name = "t_role")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "type",length = 15,unique = true,nullable = false)
    private String type = UserRoleType.USER.getUserRoleType();
    
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
    
    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
