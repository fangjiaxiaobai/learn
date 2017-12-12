package com.fxb.demo1_callableDemo;

import java.util.concurrent.Callable;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/5
 */
public class CallableDemo implements Callable<Integer> {

    public Integer sum = 0;

    @Override
    public Integer call() throws Exception {
        System.out.println("callable 子线程开始计算。。。。");
        Thread.sleep(2000);
        for (int i = 0; i < 5000; i++) {
            sum+=1;
        }
        System.out.println("callable 子线程计算结束。。。");
        return sum;
    }
}
