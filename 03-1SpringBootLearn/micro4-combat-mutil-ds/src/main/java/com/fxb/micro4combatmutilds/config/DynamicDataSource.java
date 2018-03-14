package com.fxb.micro4combatmutilds.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源路由类
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 返回的字符串会配置文件中的相应的字符串定位数据源。
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        /**
         * 获取设置的数据源，交给AbstractRoutingDataSource进行注入。
         */
        return DynamicDataSourceHolder.getDataSourceType();
    }
}
