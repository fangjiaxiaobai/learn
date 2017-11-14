package com.fxb.chapter6staticAdvisorDemo.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author 方小白 on 2017/9/27 18:55.
 * @description
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    public boolean matches(Method method, Class <?> targetClass) {
        return "greetTo".equals(method.getName());
    }
    
    @Override
    public ClassFilter getClassFilter() { // 切点类匹配规则：Waiter的类或者子类。
        return new ClassFilter() {
            public boolean matches(Class <?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
