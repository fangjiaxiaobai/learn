package demos.demo9_20171128;

/**
 * @author fangxiaobai
 * @date 2017/11/28 9:20.
 * @description Semaphore
 *
 *          Semaphore 的一个简单的实现。
 *      Take方法发出一个被存放在Semaphore内部的信号，
 * 而Release方法则等待一个信号，当其接收到信号后，标记位signal被清空，然后该方法终止。
 *
 *  使用semaphore可以避免错失某些信号的通知。
 */
public class Semaphore {
    private boolean sigal = false;
    
    public synchronized void take(){
        this.sigal = true;
        this.notify();
    }
    
    public synchronized void release() throws InterruptedException {
        while(!this.sigal){
            wait();
        }
        this.sigal = false;
    }
    
}
