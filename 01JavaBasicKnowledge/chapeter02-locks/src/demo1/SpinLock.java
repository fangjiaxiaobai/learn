package demo1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/20
 */
public class SpinLock {
    
    private AtomicReference<Thread> sign = new AtomicReference<>();
    
    public void lock(){
        Thread current = Thread.currentThread();
        // 如果sign中的被修饰Thread为null时，修改为current，返回true
        // 否则返回false
        // 只有第一个线程来到这里，不进入while，其他所有线程都会进入while
        // 除非 调用unlock。
        while(!sign.compareAndSet(null,current)){
        
        }
    }
    
    public void unlock(){
        Thread current = Thread.currentThread();
        // 实际上是把sign中的被修饰的Thread的值设置为null。、
        sign.compareAndSet(current,null);
    }
    
    
}
