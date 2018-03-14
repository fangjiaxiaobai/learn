package demo2_thread_join;

import javax.management.relation.RoleUnresolved;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class DeadLoadDemo {

    private static Object o1 = new Object();
    private static Object o2 = new Object();
   
    public static void main(String[] args) {
    
        MyRunnable r1 = new MyRunnable(false);
        MyRunnable r2 = new MyRunnable(true);
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
    
    public static class MyRunnable implements Runnable{
        private boolean flag  ;
        public MyRunnable(boolean flag){
            this.flag = flag;
        }
        @Override
        public void run() {
            while (true)
            if(flag) {
                synchronized (o1) {
                    synchronized (o2) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }else{
                synchronized (o2) {
                    synchronized (o1) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            }
        }
    }
    
}
