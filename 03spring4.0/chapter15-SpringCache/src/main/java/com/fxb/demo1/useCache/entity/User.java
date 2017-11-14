package com.fxb.demo1.useCache.entity;

import java.io.Serializable;

/**
 * @author 方小白 on 2017/10/9 15:51.
 * @description
 */
public class User implements Serializable{
    
    
    private String id;
    private String name;
    private int age;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
