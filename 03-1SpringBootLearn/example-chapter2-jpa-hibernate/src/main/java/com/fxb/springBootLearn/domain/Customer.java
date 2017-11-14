package com.fxb.springBootLearn.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 方小白 on 2017/9/13 19:53.
 * @description
 */

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid.hex")
    private String id;
    private String name;
    private int age;

    public Customer(String id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public Customer(){}

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }
}

