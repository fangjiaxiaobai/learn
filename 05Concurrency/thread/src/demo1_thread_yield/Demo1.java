package demo1_thread_yield;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class Demo1 {
    
    public static void main(String[] args) throws InterruptedException {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);
        
        t1.start();
//        Thread.sleep(200);
        t2.start();
        
        
        
    }
    
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if(i==5){
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

}
