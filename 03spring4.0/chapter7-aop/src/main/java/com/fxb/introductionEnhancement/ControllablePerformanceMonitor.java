package com.fxb.introductionEnhancement;

import com.fxb.cglib.Monitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author 方小白 on 2017/9/27 9:34.
 * @description
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor
    implements Monitorable{
    
    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal <Boolean>();
    private com.fxb.introductionEnhancement.Monitor monitor = new PerformanceMonitor();
    
    public void setMonitorActive(Boolean active) {
        monitorStatusMap.set(active);
    }
    
    // 拦截方法
    public Object invoke(MethodInvocation methodInvocation) throws Throwable{
        return null;
    }
    
    @Override
    protected Object doProceed(MethodInvocation methodInvocation) throws Throwable {
        Object obj = null;
    
        if(monitorStatusMap.get()!=null && monitorStatusMap.get()) {
            monitor.begin(methodInvocation.getClass().getName()+"."+methodInvocation.getMethod().getName());
            obj = super.doProceed(methodInvocation);
            monitor.end(methodInvocation.getClass().getName()+"."+methodInvocation.getMethod().getName());
        }
        System.out.println("拦截方法执行完毕。。。。");
        return obj;
    }
}
