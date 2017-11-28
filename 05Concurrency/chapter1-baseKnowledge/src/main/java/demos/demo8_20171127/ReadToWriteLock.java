package demos.demo8_20171127;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxiaobai
 * @date 2017/11/27 13:11.
 * @description ReadToWriteLock
 * <p>
 * 读锁升级到写锁。
 *      例如：我想一个拥有读锁的线程，也能获取写锁。
 */
public class ReadToWriteLock {
    
    
    private Map <Thread, Integer> readingThreads =
            new HashMap <Thread, Integer>();
    
    private int writeAccesses = 0;
    private int writeRequests = 0;
    private Thread writingThread = null;
    
    
    public synchronized void lockWrite()
            throws InterruptedException {
        writeRequests++;
        Thread callingThread = Thread.currentThread();
        while(!canGrantWriteAccess(callingThread)) {
            wait();
        }
        writeRequests--;
        writeAccesses++;
        writingThread = callingThread;
    }
    
    public synchronized void unlockWrite() throws InterruptedException {
        writeAccesses--;
        if(writeAccesses == 0) {
            writingThread = null;
        }
        notifyAll();
    }
    
    private boolean canGrantWriteAccess(Thread callingThread) {
        if(isOnlyReader(callingThread)) {
            return true;
        }
        if(hasReaders()) {
            return false;
        }
        if(writingThread == null) {
            return true;
        }
        if(!isWriter(callingThread)) {
            return false;
        }
        return true;
    }
    
    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }
    
    private boolean isWriter(Thread callingThread) {
        return writingThread == callingThread;
    }
    
    private boolean isOnlyReader(Thread thread) {
        return /*readers == 1 &&*/ readingThreads.get(thread) != null;
    }
}

