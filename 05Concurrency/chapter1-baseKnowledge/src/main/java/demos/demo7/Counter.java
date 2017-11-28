package demos.demo7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangxiaobai
 * @date 2017/11/23 20:48.
 * @description LockDemo1
 */
public class Counter implements Runnable{
    
    Lock lock = new ReentrantLock();
    private int count = 0;
    
    public int count(){
        lock.lock();
        int newCount = ++ count;
        try {
            Thread.sleep(200);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return newCount;
    }
    
    @Override
    public void run() {
        for(int i=0;i<10;i++){
           System.out.println( count());
        }
    }
}
