package com.fxb.security.core.context;

import org.springframework.security.core.context.*;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;

/**
 * demo08-relearn -- 源码介绍
 * @author fangjiaxiaobai@163.com
 * @date 2018-04-11
 */

/**
 * SpringSecurity的 整体上下文。
 *    存储的是上下文的信息。当前的用户是谁，是否被认证、角色，权限等信息
 *  默认使用ThreadLocal策略来存储认证信息，即线程绑定策略。
 *      还有GlobalSecurityContextHolderStrategy,InheritableThreadLocalSecurityContextHolderStrategy.策略。
 *
 */
public class SecurityContextHolder {

    public static final String MODE_THREADLOCAL = "MODE_THREADLOCAL";
    public static final String MODE_INHERITABLETHREADLOCAL = "MODE_INHERITABLETHREADLOCAL";
    public static final String MODE_GLOBAL = "MODE_GLOBAL";
    public static final String SYSTEM_PROPERTY = "spring.security.strategy";
    private static String strategyName = System.getProperty(SYSTEM_PROPERTY);
    private static SecurityContextHolderStrategy strategy;
    private static int initializeCount = 0;

    static {
        initialize();
    }

    // ~ Methods
    // ========================================================================================================

    public static void clearContext() {
        strategy.clearContext();
    }

    public static SecurityContext getContext() {
        return strategy.getContext();
    }

    public static int getInitializeCount() {
        return initializeCount;
    }

    private static void initialize() {
        if (!StringUtils.hasText(strategyName)) {
            // Set default
            strategyName = MODE_THREADLOCAL;
        }

        if (strategyName.equals(MODE_THREADLOCAL)) {
            // 创建认证策略
//            strategy = new ThreadLocalSecurityContextHolderStrategy();
        } else if (strategyName.equals(MODE_INHERITABLETHREADLOCAL)) {
            // 创建认证策略
//            strategy = new InheritableThreadLocalSecurityContextHolderStrategy();
        } else if (strategyName.equals(MODE_GLOBAL)) {
            // 创建认证策略
//            strategy = new GlobalSecurityContextHolderStrategy();
        } else {
            // Try to load a custom strategy
            try {
                Class<?> clazz = Class.forName(strategyName);
                Constructor<?> customStrategy = clazz.getConstructor();
                strategy = (SecurityContextHolderStrategy) customStrategy.newInstance();
            } catch (Exception ex) {
                ReflectionUtils.handleReflectionException(ex);
            }
        }

        initializeCount++;
    }

    public static void setContext(SecurityContext context) {
        strategy.setContext(context);
    }

    public static void setStrategyName(String strategyName) {
//        org.springframework.security.core.context.SecurityContextHolder.strategyName = strategyName;
        initialize();
    }

    public static SecurityContextHolderStrategy getContextHolderStrategy() {
        return strategy;
    }

    public static SecurityContext createEmptyContext() {
        return strategy.createEmptyContext();
    }

    @Override
    public String toString() {
        return "SecurityContextHolder[strategy='" + strategyName + "'; initializeCount="
                + initializeCount + "]";
    }
}
