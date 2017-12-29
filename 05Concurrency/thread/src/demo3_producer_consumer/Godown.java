package demo3_producer_consumer;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/28
 */
public class Godown {
    
    private static final  int MAX_SIZE = 100;
    public int currentNum ; // 当前库存量
    
    public Godown(int currentNum) {
        this.currentNum = currentNum;
    }
    
    public Godown() {
    }
    
    public synchronized void produce(int needNum) throws InterruptedException {
        while(currentNum+needNum>MAX_SIZE){
            System.out.println("需求量"+needNum+"+库存量"+currentNum+"大于最大容量，不能生产");
            wait();
        }
        currentNum += needNum;
        System.out.println("已经生产了"+needNum+"个产品，现库存量为:"+currentNum);
        notifyAll();
    }
    
    public synchronized void consume(int needNum) throws InterruptedException {
        while(currentNum<needNum){
            System.out.println("商品不足");
            wait();
        }
        currentNum-=needNum;
        System.out.println("已经消费"+needNum+"个产品，现在库存量为"+currentNum);
        notifyAll();
    }
}
