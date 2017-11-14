package com.fxb.chapter8dynamicAdvisor;

import com.fxb.beforeAdvice.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 方小白 on 2017/9/27 20:27.
 * @description
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    
    private static List <String> specialClientList = new ArrayList <String>();
    
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }
    
    /**
     * 对类进行静态切点检查
     * @return
     */
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class <?> clazz) {
                System.out.println("调用getClassFilter()对" + clazz.getName() + "做静态检查");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
    
    /**
     * 对方法进行动态切点检查
     * @param method
     * @param targetClass
     * @param args
     * @return
     */
    public boolean matches(Method method, Class <?> targetClass, Object... args) {
        System.out.println("调用matches(method,clazz)"+targetClass.getName()+"."+method.getName()+"做动态检查");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }
    
    /**
     * 对方法进行静态切点检查
     * @param method
     * @param clazz
     * @return
     */
    public boolean matches(Method method,Class clazz){
        System.out.println("调用matches(method,clazz)"+clazz.getName()+"."+method.getName()+"做静态检查");
        return "greetTo".equals(method.getName());
    }
}
