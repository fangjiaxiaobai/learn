package demos.demo8_20171127;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxiaobai
 * @date 2017/11/27 10:24.
 * @description ReentrantReaderWriterLock
 * <p>
 *    可重入的读锁实现。
 * 首先建立一个锁重入规则：
 * 要保证某个线程中的锁可重入性，要么满足读锁的条件(没有写或写请求)，要么已经持有读锁(不管是否有写请求)
 * <p>
 * 要确定一个线程是否已经持有读锁，可以用一个map来存储已经持有读锁的线程以及对应线程读取锁的次数，
 * 当需要判断某个线程能够获取读锁时，就利用map中存储的数据进行判断。
 * <p>
 * 只有在没有线程拥有写锁的情况下，才允许读锁的重入，此外，重入的读锁比写锁优先级高。
 */
public class ReentrantReaderLock {
    
    private Map <Thread, Integer> readingThreads = new HashMap <>();
    private int writers = 0;
    private int readers = 0;
    private int requestWriters = 0;
    
    private synchronized void lockReader() throws InterruptedException {
        Thread thread = Thread.currentThread();
        if(!canGrantReadAccess(thread)) {
            wait();
        }
        readingThreads.put(thread, getAccessCount(thread) + 1);
    }
    
    private synchronized void unlockReader() {
        Thread thread = Thread.currentThread();
        int accessCount = getAccessCount(thread);
        if(accessCount == 1) {
            readingThreads.remove(thread);
        } else {
            readingThreads.put(thread, accessCount - 1);
        }
        notifyAll();
    }
    
    private int getAccessCount(Thread t) {
        Integer integer = readingThreads.get(t);
        if(integer == null) {
            return 0;
        }
        return integer.intValue();
    }
    
    private boolean canGrantReadAccess(Thread t) {
        if(writers > 0) {
            return false;
        }
        
        if(isReader(t)) {
            return true;
        }
        
        if(requestWriters > 0) {
            return false;
        }
        
        return true;
    }
    
    /**
     * 是否 是读锁
     *
     * @param t
     * @return
     */
    private boolean isReader(Thread t) {
        return readingThreads.get(t) == null;
    }
}