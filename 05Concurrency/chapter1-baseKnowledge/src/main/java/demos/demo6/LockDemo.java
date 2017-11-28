package demos.demo6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/23 15:54.
 * @description LockDemo
 *      公平锁的实现demo
 *      将每个调用lock()的线程都会进入一个队列，当解锁后，只有队列里的第一个线程
 *      允许锁住fairLock实例，所有其他的线程都将处于等待状态，直到他们处于队列的头部。
 *
 */
public class LockDemo {
    
    private boolean isLocked = false;
    
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();
    
    public void lock() throws InterruptedException{
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized(this){
            waitingThreads.add(queueObject);
        }
        while(isLockedForThisThread) {
            synchronized(this){
                isLockedForThisThread = isLocked || waitingThreads.get(0)!= queueObject;
            }
            if(!isLockedForThisThread) {
                isLocked = true;
                waitingThreads.remove(queueObject);
                lockingThread = Thread.currentThread();
                return;
            }
        }
        try {
            queueObject.doWait();
        }catch(InterruptedException e){
            synchronized(this){
                waitingThreads.remove(queueObject);
            }
            throw e;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
