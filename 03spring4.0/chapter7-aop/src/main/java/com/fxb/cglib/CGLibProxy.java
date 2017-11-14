package com.fxb.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 方小白 on 2017/9/26 20:26.
 * @description
 */
public class CGLibProxy implements MethodInterceptor {
    
    Monitor monitor = new Monitor();
    private Enhancer enhancer = new Enhancer();
    
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz); // 设置需要创建子类的类。
        enhancer.setCallback(this);
        return enhancer.create(); // 通过字节码技术动态创建子类实例
    }
    
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        
        String methodName = method.getName();
        
        monitor.start(methodName);
        Object object  = methodProxy.invokeSuper(o,objects);
        monitor.end(methodName);
        return object;
    }
    
    
}
