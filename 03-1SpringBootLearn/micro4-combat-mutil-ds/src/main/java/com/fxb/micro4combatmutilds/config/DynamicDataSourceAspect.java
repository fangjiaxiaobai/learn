package com.fxb.micro4combatmutilds.config;

import com.fxb.micro4combatmutilds.config.annotation.TargetDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切换数据源Advice
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
@Aspect
@Order
@Component
public class DynamicDataSourceAspect {

    private Logger logger =LoggerFactory.getLogger(DynamicDataSourceAspect.class);
    
    /**
     *
     * @param point
     * @param dataSource
     */
    @Before("@annotation(dataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource dataSource) {
    
        // 获取当前数据源ID
        String dsId=dataSource.value();
        // 如果不在我们注入的所有数据源范围内，那么输出告警信息，系统自动使用默认的数据源。
        if (!DynamicDataSourceHolder.containsDataSource(dsId)) {
            logger.warn("the dataSource which named {} is not exist, should use the default dataSource ---by fangxiaobai  >{}"
            ,dataSource.value(),point.getSignature());
        }else{
            logger.info("use dataSource : {}",dataSource.value(),point.getSignature());
            DynamicDataSourceHolder.setDataSourceType(dataSource.value());
        }
    }
    
    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point,TargetDataSource targetDataSource){
        logger.info("reset the dataSource : {} ",targetDataSource.value(),point.getSignature());
        DynamicDataSourceHolder.clearDataSoruceType();
    }

}
