package demos.demo5;

/**
 * @author fangxiaobai
 * @date 2017/11/22 10:02.
 * @description DeadLockDemo1
 *
 *      一个特别简单的死锁栗子，  注意：要让线程睡一会，这样 必然死锁。
 *          会一个死锁栗子就行，要做的是如何避免死锁。
 *
 *
 */
public class DeadLockDemo1 implements Runnable {
    
    public boolean flag = false;
    
    private static Object o1 = new Object();
    private static Object o2 = new Object();
    
    @Override
    public void run() {
        
        if(flag){
            System.out.println("flag = true");
            synchronized(o1){
                System.out.println("get o1 lock, try to get o2 lock..");
                try {
                    Thread.sleep(200);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o2){
                    System.out.println("get o1 lock");
                }
            }
        }else{
            System.out.println("flag = false");
            synchronized(o2){
                System.out.println("get o2 lock , try to get o1 ");
                try {
                    Thread.sleep(200);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o1){
                    System.out.println("get o1 lock");
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        DeadLockDemo1 d1 = new DeadLockDemo1();
        d1.flag = true;
        DeadLockDemo1 d2 = new DeadLockDemo1();
        d2.flag = false;
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        
        t1.start();
        t2.start();
    }
}
