package demos.demo10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/28 13:49.
 * @description ThreadPool
 */
public class ThreadPool {
    
    private BlockingQueue taskQueue = null;
    private List <PoolThread> threads = new ArrayList <>();
    private boolean isStopped = false;
    
    public ThreadPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new BlockingQueue(maxNoOfTasks);
        
        for(int i = 0; i < noOfThreads; i++) {
            threads.add(new PoolThread(taskQueue));
        }
        
        for(PoolThread thread : threads) {
            thread.start();
        }
    }
    
    public synchronized void execute(Runnable task) throws InterruptedException {
        if(this.isStopped) {
            throw new IllegalStateException("ThreadPool is Stopped");
        }
        this.taskQueue.enqueue(task);
    }
    
    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads) {
            thread.stop();
        }
    }
    
}
