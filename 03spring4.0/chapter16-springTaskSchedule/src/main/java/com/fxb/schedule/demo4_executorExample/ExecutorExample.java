package com.fxb.schedule.demo4_executorExample;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author fangxiaobai on 2017/10/17 15:09.
 * @description
 *
 *      6个任务 共享了 线程池中的3个线程，由于ExecutporService用线程中的3个线程服务于提交的任务
 *   从而避免了为每个任务创建独立线程的代价，具有更好的性能。
 */
public class ExecutorExample {
    
    // 声明一个执行器
    private Executor executor;
    
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }
    
    public void executeTasks(){
        for(int i = 0; i < 6; i++){
            executor.execute(new SimpleTask("task"+i));
        }
    }
    
    
    public static void main(String[] args) {
        ExecutorExample ee = new ExecutorExample();
        ee.setExecutor(Executors.newFixedThreadPool(3));
        ee.executeTasks();
    }
}
