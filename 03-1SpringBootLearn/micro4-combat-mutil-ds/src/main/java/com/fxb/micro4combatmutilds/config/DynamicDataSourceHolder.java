package com.fxb.micro4combatmutilds.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态数据源上下文
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class DynamicDataSourceHolder {
    
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    
    /**
     * 管理所有的数据源id
     * 主要是为了判断数据源是否存在
     */
    public static List<String> dataSourceIds = new ArrayList<>();
    
    public static void setDataSourceType(String dataSourceType){
        contextHolder.set(dataSourceType);
    }
    
    public static String getDataSourceType(){
        return contextHolder.get();
    }
    
    public static void clearDataSoruceType(){
        contextHolder.remove();
    }
    
    /**
     * 判断指定dataSource是否存在
     * @param dataSourceId
     * @return
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
    
}
