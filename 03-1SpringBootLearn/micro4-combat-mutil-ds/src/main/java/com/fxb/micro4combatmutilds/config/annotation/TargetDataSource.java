package com.fxb.micro4combatmutilds.config.annotation;

import java.lang.annotation.*;

/**
 * 指定数据源注解类
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    
    String value();
    
}
