package demos.demo6;

/**
 * @author fangxiaobai
 * @date 2017/11/23 16:03.
 * @description QueueObject
 */
public class QueueObject {
    
    private boolean isNotified = false;
    
    public synchronized  void doWait() throws InterruptedException{
        while(!isNotified){
            this.wait();
        }
        this.isNotified = false;
    }
    
    public synchronized void doNotity(){
        this.isNotified = true;
        this.notify();
    }
    
    @Override
    public boolean equals(Object o){
        return this == o;
    }
    
}
