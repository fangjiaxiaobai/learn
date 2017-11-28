package demos.demo8_20171127;

/**
 * @author fangxiaobai
 * @date 2017/11/27 10:05.
 * @description ReadWriterLocks
 * <p>
 * 模仿一个简单的读写锁的实现
 */
public class ReadWriterLocks {
    
    private int readers;
    private int writers;
    private int requestWriters;
    
    /**
     * 加上读锁
     *
     * @throws InterruptedException
     */
    private synchronized void lockReader() throws InterruptedException {
        if(requestWriters > 0 || writers > 0) {
            wait();
        }
        readers++;
    }
    
    /**
     * 释放读锁
     */
    private synchronized void unlockReader() {
        readers--;
        notifyAll(); // 注1
    }
    
    /**
     * 加写锁
     *
     * @throws InterruptedException
     */
    private synchronized void lockWriter() throws InterruptedException {
        requestWriters++;
        if(writers > 0 || readers > 0) {
            wait();
        }
        requestWriters--;
        writers++;
    }
    
    /**
     * 释放写锁
     */
    private synchronized void unlockWriter() {
        writers--;
        notifyAll();// 注1
    }
    
    
}


/**
 注1：如果有线程在等待获取读锁，同时又有线程在等待获取写锁。
 如果这时其中一个等待读锁的线程被notify方法唤醒，但因为此时仍有请求写锁的线程存在（writeRequests>0），
 所以被唤醒的线程会再次进入阻塞状态。然而，等待写锁的线程一个也没被唤醒，就像什么也没发生过一样（译者注：信号丢失现象）。
 如果用的是notifyAll方法，所有的线程都会被唤醒，然后判断能否获得其请求的锁。
 用notifyAll还有一个好处。如果有多个读线程在等待读锁且没有线程在等待写锁时，调用unlockWrite()后，所有等待读锁的线程都能立马成功获取读锁
 而不是一次只允许一个。
 
 注2：
    这个读写锁是不可重入的。为什么？
    当有了一个写进程，就满足了readers>0(在lockReader中),当它还想获取读锁的时候，就会一直阻塞。
    这种情况就类似于一种死锁情况，不会再有任何一个线程能够成功的获取读锁或者写锁。
    
    写一个可重入的读写锁。见Demo2
 
 */