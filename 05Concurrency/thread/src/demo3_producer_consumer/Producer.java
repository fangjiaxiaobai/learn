package demo3_producer_consumer;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class Producer extends Thread {

    private int needNum;
    private Godown godown;
    
    Producer(int needNum,Godown godown){
        this.godown = godown;
        this.needNum = needNum;
    }
    
    public void produce(int needNum) throws InterruptedException {
        godown.produce(needNum);
    }
    
    @Override
    public void run() {
        try {
            produce(needNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
