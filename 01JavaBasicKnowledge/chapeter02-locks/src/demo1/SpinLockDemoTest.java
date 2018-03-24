package demo1;

import sun.security.provider.ConfigFile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/20
 */
public class SpinLockDemoTest {
    
    public static void main(String[] args) {
        
        ThreadDemo threadDemo=new ThreadDemo();
        
        Thread thread1=new Thread(threadDemo);
        Thread thread2=new Thread(threadDemo);
        
        thread1.start();
        thread2.start();
        
        
    }
    
    private static class ThreadDemo implements Runnable {
        
        public int i=0;
        SpinLock sl=new SpinLock();
        
        @Override
        public void run() {
            
            while (i++ <100) {
//                sl.lock();
                int j = 0;
                while(j++ < 10) {
                    System.out.println(Thread.currentThread().getName());
                }
//                sl.unlock();
            }
        }
    }
    
    
}
