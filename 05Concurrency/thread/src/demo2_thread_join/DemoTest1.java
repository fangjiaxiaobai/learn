package demo2_thread_join;

import demo1_thread_yield.Demo1;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class DemoTest1 {
    public static void main(String[] args) throws InterruptedException {
        Demo1.MyRunnable mr = new Demo1.MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);
        t1.start();
        t2.start();
        t1.join();
        t1.join();
        t3.start();
    
    }
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if(i==5){
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
