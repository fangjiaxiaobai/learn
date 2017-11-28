package demos.demo4;

/**
 * @author fangxiaobai
 * @date 2017/11/22 9:46.
 * @description ThreadLocalDemo
 */
public class ThreadLocalDemo {
    
    public static class MyRunnable implements Runnable{
    
        private ThreadLocal<Integer> local = new ThreadLocal(){
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };
    
        @Override
        public void run() {
            local.set((int)(Math.random()*100D));
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(local.get());
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
}
