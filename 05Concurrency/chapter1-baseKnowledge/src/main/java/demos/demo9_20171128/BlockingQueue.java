package demos.demo9_20171128;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fangxiaobai
 * @date 2017/11/28 11:56.
 * @description BlockingQueue
 * <p>
 * 阻塞队列。
 * 特点：试图从空的阻塞队列中获取元素的线程将会被阻塞，直到其他的线程往空的队列插入新的元素。
 * 同样，试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞，
 * 直到其他的线程使队列重新变得空闲起来，如从队列中移除一个或者多个元素，或者完全清空队列，
 */
public class BlockingQueue {
    
    private List queue = new LinkedList();
    
    private int limit = 0;
    
    public BlockingQueue(int limit) {
        this.limit = limit;
    }
    
    /***
     * 进队
     * @param item
     * @throws InterruptedException
     */
    public synchronized void enqueue(Object item) throws InterruptedException {
        while(this.queue.size()==this.limit){  // 队列达到上限，不能添加元素
            wait();
        }
        if(queue.size()==0){
            notifyAll();
        }
        this.queue.add(item);
    }
    
    public synchronized Object dequeue() throws InterruptedException {
        while(queue.size()==0){  // 队列达到下限。 不能删除元素
            wait();
        }
        if(this.queue.size()==this.limit){
            notifyAll();
        }
        return this.queue.remove(0); // 移除第一个
    }
    
}
/**
 在enqueue和dequeue方法内部，只有队列的大小等于上限（limit）或者下限（0）时，才调用notifyAll方法。
 如果队列的大小既不等于上限，也不等于下限，任何线程调用enqueue或者dequeue方法时，都不会阻塞，
 都能够正常的往队列中添加或者移除元素。
 */