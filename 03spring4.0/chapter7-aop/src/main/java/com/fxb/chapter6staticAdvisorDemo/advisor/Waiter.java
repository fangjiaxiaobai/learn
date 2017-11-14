package com.fxb.chapter6staticAdvisorDemo.advisor;

/**
 * @author 方小白 on 2017/9/27 18:49.
 * @description
 */
public class Waiter {
    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + " ...");
    }
    
    public void serveTo(String name){
        System.out.println("waiter serving "+name +" ...");
    }
    
}
