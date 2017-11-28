package demos.demo1;

/**
 * @author fangxiaobai
 * @date 2017/11/3 14:22.
 * @description DemoTest1
 */
public class DemoTest1 {
    
    public static void main(String[] args) {
    
        for(int i = 0; i < 10 ; i++) {
            new Thread(()->new LoggingWidget().doSomething()).start();
        }
    }
    
}
