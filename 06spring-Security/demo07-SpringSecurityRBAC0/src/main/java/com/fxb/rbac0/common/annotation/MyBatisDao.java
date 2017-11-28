package com.fxb.rbac0.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author fangxiaobai
 * @date 2017/11/21 18:01.
 * @description MyBatisDao
 */

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyBatisDao
{
}
