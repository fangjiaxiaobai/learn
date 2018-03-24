package demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ticket锁主要解决访问顺序的问题，问题是在多核CPU上
 *  票号只会增加，也就是说访问的次数和拿到的票号对应的时候，才能顺利执行，否则就会进入while。编程自旋状态。
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/20
 */
public class SpinLock_TicketLock {
    
    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();
    private static final ThreadLocal<Integer> LOCAl = new ThreadLocal<>();
    
    public void lock(){
        int myTicket = ticketNum.getAndIncrement();
        LOCAl.set(myTicket);
        // 每次都回到主存中读取，组织其他CPU修改，影响性能
        while(myTicket!=serviceNum.get()){
        
        }
    }
    
    
    public void unlock(){
        int myTicket = LOCAl.get();
        serviceNum.compareAndSet(myTicket,myTicket+1);
    }
    
    
}
