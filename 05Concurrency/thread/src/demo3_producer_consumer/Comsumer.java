package demo3_producer_consumer;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class Comsumer extends Thread {

    private int needNum;
    private Godown godown;
    
    public Comsumer(int needNum, Godown godown) {
        this.needNum = needNum;
        this.godown = godown;
    }

    public void run(){
        try {
            godown.consume(needNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
