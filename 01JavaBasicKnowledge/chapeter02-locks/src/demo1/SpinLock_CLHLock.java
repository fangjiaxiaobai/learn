package demo1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * CLHlock是不停的查询前驱变量，导致不适合在 NUMA架构下使用
 * NUMA架构？？
 *      非统一内存访问。一种用于多处理器的电脑记忆体设计，内存访问时间取决于处理器的内存位置。
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/20
 */
public class SpinLock_CLHLock {
 
    public static class CLHNode{
        private volatile boolean isLocked = true;
    }
    
    private volatile CLHNode tail;
    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();
    private static final AtomicReferenceFieldUpdater<SpinLock_CLHLock,CLHNode> UPDATER
        = AtomicReferenceFieldUpdater.newUpdater(SpinLock_CLHLock.class,CLHNode.class,"tail");
    
    public void lock(){
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        CLHNode preNode=UPDATER.getAndSet(this, node);
        if (null!=preNode) {
            while (preNode.isLocked) {
            
            }
            preNode = null;
            LOCAL.set(node);
        }
    }
    
    public void unlock(){
        CLHNode node = LOCAL.get();
        if (!UPDATER.compareAndSet(this,node,null)) {
            node.isLocked = false;
        }
        node = null;
    }
    
    
    
}
