package com.fxb.springBootLearn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wangxiyue on 2017/9/17 16:20.
 * @description
 */

@Component
@ConfigurationProperties(prefix = "author") // 加载properties文件内的配置，
                                            //prefix属性指定properties的配置前缀
                                            // locations指定properties文件的位置。
public class AuthorSettings {
    
    private String name;
    private int age;
    
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
