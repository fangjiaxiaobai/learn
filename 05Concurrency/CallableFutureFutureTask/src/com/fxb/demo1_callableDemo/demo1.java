package com.fxb.demo1_callableDemo;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/5
 *
 *      创建多线程的方式除了实现Runnable接口，另外一种就是继承Thread。
 *   还有就是实现Callable接口。
 *        前两种实现方式，在任务执行完成后无法获取返回结果。
 *    jdk1.5之后，引入了Callable和Future接口，通过他们构建的线程，在任务执行完成后，就可以获取执行结果。
 *
 *  1.Callable接口
 *  2.Future接口： 用来获取异步计算结果。
 *      也就是对具体的Runnable或者callable对象任务执行的结果进行获取,取消，判断是否完成等操作。
 *  Future接口提供了3中功能，
 *      1.能够中断执行中的任务，
 *      2.判断任务是否执行完成
 *      3.获取任务执行完成后的结果。
 *  3.FutureTask类是Future的实现类。
 *      FutureTask类除了实现了Future接口还实现了Runnable接口，因此FutureTask也可以直接提交给Executor执行。
 *      也可以直接调用FutureTask.run()
 */
public class demo1 {

    public static void main(String[] args) {
//        demoTest1();
        long l1 = System.currentTimeMillis();
        demoTest3();
        long l2 = System.currentTimeMillis();
        demoTest2();
        long l3 = System.currentTimeMillis();
        System.out.println("普通计算："+(l2-l1));
        System.out.println(l3-l2);
    }

    /**
     * 使用Callable+future获取执行结果
     */
    public static void demoTest1() {
        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 创建callable对象 -- 任务
        CallableDemo callableDemo = new CallableDemo();
        // 提交任务并获取执行结果，
        Future<Integer> submit = executorService.submit(callableDemo);
        // 关闭线程池
        executorService.shutdown();
        try {
        Thread.sleep(2000);
        System.out.println("主线程正在执行其他任务");


            if (submit.get() !=null) {
                System.out.println("future.get()->"+submit.get());
            }else {
                System.out.println("future.get() 未获取到结果");
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程正在执行其他任务");

    }

    /**
     * 通过 Callable+FutureTask 获取执行结果
     */
    public static  void  demoTest2(){

        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 创建Callable对象  -- 任务
        CallableDemo callableDemo = new CallableDemo();

        // 创建FutureTask
        FutureTask<Integer> integerFuture = new FutureTask<>(callableDemo);

        executorService.submit(integerFuture);

        executorService.shutdown();

        try {
            Thread.sleep(2000);
            System.out.println("主线程正在执行其他任务");

            if (integerFuture.get()!=null) {
                System.out.println("future.get()->"+integerFuture.get());
            }else {
                System.out.println("future.get() 未获取到结果");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行完毕......");
    }

    public static void demoTest3(){
        int sum = 0;
        for (int i = 0; i < 5000; i++) {
            sum+=i;
        }
        System.out.println("sum="+sum);
    }

}
