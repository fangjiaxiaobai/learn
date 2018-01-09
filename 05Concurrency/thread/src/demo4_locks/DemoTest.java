package demo4_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class DemoTest {

    private static Lock lock = new ReentrantLock(true);
    
    public static void main(String[] args) {
        Runnable r = ()->{
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("当前线程为"+Thread.currentThread().getName());
            }
            lock.unlock();
        };
        
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }


}
