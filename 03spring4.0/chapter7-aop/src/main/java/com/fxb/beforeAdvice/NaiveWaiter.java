package com.fxb.beforeAdvice;

/**
 * @author 方小白 on 2017/9/26 20:56.
 * @description
 */
public class NaiveWaiter implements Waiter{
    public void greetTo(String name) {
        System.out.println("greet to "+ name);
    }
    
    public void serveTo(String name) {
        System.out.println("serve to "+ name);
    }
    
    public void throwsTo(String name) {
        throw new RuntimeException("哎呀，发生异常了");
    }
}
