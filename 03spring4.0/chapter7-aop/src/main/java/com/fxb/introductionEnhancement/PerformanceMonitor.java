package com.fxb.introductionEnhancement;

/**
 * @author wangxiyue on 2017/9/27 9:39.
 * @description
 */
public class PerformanceMonitor implements Monitor{
    
    public void begin(String name) {
        System.out.println("monitor ..begin..  "+name);
    }
    
    public void end(String name) {
        System.out.println("monitor ..end..  "+name);
    }
}
