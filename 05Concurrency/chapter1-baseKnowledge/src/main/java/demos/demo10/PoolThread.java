package demos.demo10;


/**
 * @author fangxiaobai
 * @date 2017/11/28 13:51.
 * @description PoolThread
 */
public class PoolThread extends Thread {
    
    private java.util.concurrent.BlockingQueue<Runnable> taskQueue = null;
    
    private boolean isStopped = false;
    
    public PoolThread(BlockingQueue taskQueue) {
        taskQueue = taskQueue;
    }
    
    @Override
    public void run(){
        while(!isStopped){
            try{
                Runnable runnable = taskQueue.take();
                runnable.run();
            }catch(Exception e){
                // 写日志或者报告异常。
                //但保持线程池异常。
            }
        }
    }
    
    public synchronized void toStop(){
        isStopped = true;
        this.interrupt(); // 打断池中线程的dequeue的调用。
    }
    
    public synchronized boolean isStopped(){
        return isStopped;
    }
}
