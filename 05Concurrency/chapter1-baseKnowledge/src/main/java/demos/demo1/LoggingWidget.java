package demos.demo1;

/**
 * @author fangxiaobai
 * @date 2017/11/3 14:20.
 * @description LoggingWidget
 *
 *      验证 内置锁是可以重入的。
 *          重入：某个线程试图获取一个已经由自己持有的锁，重入意味着获取锁的操作的粒度是“线程”，不是调用。
 *
 *      由于Widget和LoggingWidget中doSomething方法都是synchronized方法，
 *      因此每个doSomething方法在执行前都会获取Widget上的锁。。
 *      如果 内置锁不是可重入的，那么在调用super.doSomething时将无法获取Widget上的锁，
 *      因为这个锁已经被持有，从而线程将被永远停顿下去，等待一个永远也无法获取的锁。
 *      重入则避免了这种死锁情况的发生。
 *
 */
public class LoggingWidget extends Widget {
    
    @Override
    public synchronized void doSomething() {
        System.out.println(toString()+": call to do something ...");
        super.doSomething();
    }
}
