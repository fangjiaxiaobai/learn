package com.fxb.rbac.entity;

import com.fxb.rbac.common.Entity;

/**
 * @author fangxiaobai
 * @date 2017/11/15 13:13.
 * @description Permission
 */
public class Menu extends Entity{
    
    private String parentId;  //
    private Menu parentMenu;
    private String parentIds; // 所有父级编号
    private String name;  // 路径名
    private String permission;  //权限标识
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    public String getParentIds() {
        return parentIds;
    }
    
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPermission() {
        return permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    public Menu getParentMenu() {
        return parentMenu;
    }
    
    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }
}
