package _01_semaphoreDemo;

import java.util.concurrent.*;

/**
 * @author fangxiaobai
 * @date 2017/11/28 14:13.
 * @description DemoTest1
 *
 * Semaphore的官方解释：什么玩意儿。。。。。。。
 *      一个计数信号量，从概念上讲，信号量维护了一个许可集。
 * 如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。
 * 每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。
 * 但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。
 * 拿到信号量的线程可以进入代码，否则就等待。通过acquire()和release()获取和释放访问许可。
 *
 *      下面这个例子  演示：
 *          最多只允许5个线程同时进入执行acquire()和release()之间的代码。
 *
 *
 */
public class DemoTest1 {
   
    
    public static void main(String[] args) {
    
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        
        final Semaphore semaphore = new Semaphore(5); // 只能5个线程同时访问。
    
        for(int i = 0; i < 20; i++) {
            final int NO = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println("Accessing: "+NO);
                        Thread.sleep((long) (Math.random()*10000));
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                        System.out.println("------------");
                    }
                }
            };
            executorService1.execute(run);
        }
        executorService1.shutdown();
    }
    
}
