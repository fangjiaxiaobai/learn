package com.fxb.schedule.demo4_executorExample;

/**
 * @author fangxiaobai on 2017/10/17 15:11.
 * @description
 */
public class SimpleTask implements Runnable {
    private String taskName;
    public SimpleTask(String s) {
        taskName = s;
    }
    
    
    public void run() {
        System.out.println("do "+ taskName + "...in Thread:"+Thread.currentThread().getId());
    }
}
