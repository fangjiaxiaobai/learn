package demos.demo3;

/**
 * @author fangxiaobai
 * @date 2017/11/21 15:45.
 * @description Counter
 */
public class Counter {
    
    long count = 0;
    
    public synchronized void add(long value){
        this.count += value;
    }
    
    public long getCount() {
        return count;
    }
}
