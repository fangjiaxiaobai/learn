package demos.demo7;

/**
 * @author fangxiaobai
 * @date 2017/11/23 20:50.
 * @description DemoTest
 */
public class DemoTest {
    
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        t1.start();
        t2.start();
    }
    
}
