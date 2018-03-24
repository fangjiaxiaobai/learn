package demo1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 *  MCS是对本地变量的节点进行循环，不存在CLHLock的问题。
 * MCS 的队列是显式的队列，有真实的后继结点属性。
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/22
 */
public class SpinLock_MCSLock {
    
    public static class MCSNode{
        volatile MCSNode next;
        volatile boolean isLocked = true;
    }
    
    private static final ThreadLocal<MCSNode> NODE = new ThreadLocal<>();
    
    private volatile MCSNode queue;
    private static final AtomicReferenceFieldUpdater<SpinLock_MCSLock,MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(SpinLock_MCSLock.class,MCSNode.class,"queue");
    
     public void lock(){
         MCSNode currentNode = new MCSNode();
         NODE.set(currentNode);
         MCSNode preNode=UPDATER.getAndSet(this, currentNode);
         
         if(null!=preNode){
             preNode.next = currentNode;
             while(currentNode.isLocked){
             
             }
         }
     }
    
     public void unlock(){
         MCSNode currentNode =NODE.get();
         if(null == currentNode.next){
             if(UPDATER.compareAndSet(this,currentNode,null)){
             
             }else{
                 while(null == currentNode){}
             }
         }else{
             currentNode.next.isLocked = false;
             currentNode.next = null;
         }
     }
    
    
}
