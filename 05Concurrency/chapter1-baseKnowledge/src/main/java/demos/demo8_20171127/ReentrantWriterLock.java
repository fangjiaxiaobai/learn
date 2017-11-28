package demos.demo8_20171127;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxiaobai
 * @date 2017/11/27 12:50.
 * @description ReentrantWriterLock
 * <p>
 * 可重入的写锁
 * <p>
 * 注意 在确定当前线程是否能够获取写锁的时候，是如何处理的
 */
public class ReentrantWriterLock {
    
    private Map <Thread, Integer> readingThreads = new HashMap <>();
    private int writeAccess = 0;
    private int writeRequest = 0;
    private Thread writingThread = null;
    
    /**
     * 加写锁
     *
     * @throws InterruptedException
     */
    public synchronized void lockWrite() throws InterruptedException {
        writeRequest++;
        Thread thread = Thread.currentThread();
        while(!canGrantWriteAccess(thread)) {
            wait();
        }
        writeRequest--;
        writeAccess++;
        writingThread = thread;
    }
    
    public synchronized void unlockWrite() {
        writeAccess--;
        if(writeAccess == 0) {
            writingThread = null;
        }
        notifyAll();
    }
    
    private boolean canGrantWriteAccess(Thread thread) {
        if(hasReaders()) {
            return false;
        }
        if(null == thread) {
            return true;
        }
        if(!isWriter(thread)) {
            return false;
        }
        return true;
    }
    
    private boolean isWriter(Thread thread) {
        return writingThread == thread;
    }
    
    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }
    
    
}
