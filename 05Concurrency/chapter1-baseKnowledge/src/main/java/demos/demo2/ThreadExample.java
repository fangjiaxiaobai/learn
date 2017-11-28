package demos.demo2;

/**
 * @author fangxiaobai
 * @date 2017/11/21 14:48.
 * @description ThreadExample
 */
public class ThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    
        for( int i = 0; ; i++) {
            new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
        }
        
    }
    
}
