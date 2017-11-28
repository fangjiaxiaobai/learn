package demos.demo3;

/**
 * @author fangxiaobai
 * @date 2017/11/21 15:47.
 * @description Example
 */
public class Example {
    
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread = new CounterThread(counter);
        Thread thread1 = new CounterThread(counter);
        thread.start();
        thread1.start();
    }
    
}
