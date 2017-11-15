package com.fxb.rbac.common;

import java.io.Serializable;

/**
 * @author fangxiaobai
 * @date 2017/11/15 11:54.
 * @description Entity
 */
public class Entity implements Serializable{
    private String id;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
}
