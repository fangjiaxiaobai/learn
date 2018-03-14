package demo3_producer_consumer;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class DemoTest {
    
    public static void main(String[] args) {
        Godown godown = new Godown(50);
        Producer p1 = new Producer(50,godown);
        Producer p2 = new Producer(30,godown);
        Comsumer c1 = new Comsumer(10,godown);
        Comsumer c2 = new Comsumer(10, godown);
        c1.start();
        p1.start();
        c2.start();
        p2.start();
    
    
    }
}
