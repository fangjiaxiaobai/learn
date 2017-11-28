package demos.demo8_20171127;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxiaobai
 * @date 2017/11/27 19:22.
 * @description ReentrantWriteReadLock
 */
public class ReentrantWriteReadLock {
    
    private Map<Thread,Integer> readdingThreads = new HashMap <>();
    
   private int requestWriters = 0;
   private int writers = 0;
   private Thread writtingThread = null;
    
    /**
     *  读 锁
     * @throws InterruptedException
     */
   public synchronized void lockRead() throws InterruptedException {
       Thread thread = Thread.currentThread();
       while(!canGrantReadAccess(thread)){
           wait();
       }
       readdingThreads.put(thread,getReadAccessCount(thread)+1);
   }
    
    /**
     * 释放 读锁
     */
   public synchronized void unlockRead() {
       Thread thread = Thread.currentThread();
       if(!isReader(thread)){
           throw new IllegalArgumentException("Calling Thread does not" +
                   "hold a read lock on this ReadWriterLock");
       }
    
       int accessCount = getReadAccessCount(thread);
       if(accessCount==1) {
           readdingThreads.remove(thread);
       }else{
           readdingThreads.put(thread,accessCount-1);
       }
       notifyAll();
   }
    
    /**
     * 写 锁
     * @throws InterruptedException
     */
   public synchronized void lockWriter() throws InterruptedException {
       requestWriters++;
       Thread thread = Thread.currentThread();
       while(!canGrantWriterAccess(thread)){
           wait();
       }
       requestWriters--;
       writers++;
       writtingThread = thread;
   }
   
   
    
    /**
     * 是否能够授予写权限。
     * @param thread
     * @return boolean
     */
    private boolean canGrantWriterAccess(Thread thread) {
       if(isOnlyReader(thread)){
           return true;
       }
       if(hasReaders()){
           return false;
       }
        if(null==writtingThread) {
            return true;
        }
        if(!isWriter(thread)){
           return false;
        }
        return true;
    }
    
    private boolean isReader(Thread thread) {
        return readdingThreads.get(thread) == null;
    }
    
    private int getReadAccessCount(Thread thread) {
        Integer integer = readdingThreads.get(thread);
        if(null==integer) {
            return 0;
        }
        return integer.intValue();
    }
    
    /**
     *  是否能够授予读权限
     * @param thread
     * @return
     */
    private boolean canGrantReadAccess(Thread thread) {
        if(isOnlyReader(thread)) {
            return true;
        }
        if(hasReaders()){
            return false;
        }
        if(writtingThread==null){
            return true;
        }
        if(!isWriter(thread)){
            return false;
        }
        return true;
    }
    
    private boolean isWriter(Thread thread) {
        return writtingThread == thread;
    }
    
    private boolean hasReaders() {
        return readdingThreads.size()>0;
    }
    
    private boolean isOnlyReader(Thread thread) {
        return readdingThreads.size()==1&&readdingThreads.get(thread)!=null;
    }
    
    
}
