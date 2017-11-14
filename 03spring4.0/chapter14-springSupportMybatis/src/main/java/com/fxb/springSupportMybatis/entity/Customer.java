package com.fxb.springSupportMybatis.entity;

/**
 * @author 方小白 on 2017/9/29 20:35.
 * @description
 */

public class Customer {
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
