package demos.demo3;

/**
 * @author fangxiaobai
 * @date 2017/11/21 15:46.
 * @description CounterThread
 */
public class CounterThread extends Thread {
    
    protected Counter counter = null;
    
    public CounterThread(Counter counter){
        this.counter = counter;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 10; i++) {
            counter.add(1);
            try {
               sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--i="+i+"--"+counter.getCount());
            
        }
    }
    
}
