package demo1_automic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/27
 *
 *  学习java.util.concurrent.atomic包,JDK提供的一组原子操作类。
 *      方便在无锁的情况下，进行原子操作。
 *      原子变量的底层使用的CPU的原子指令。
 *Atomic分类：
 *      atomic包下面总共12个类(class)：
 *      根据其作用分为4类：
* 原子更新基本类型： AtomicBoolean :原子更新布尔类型。AtomicInteger:原子更新整型，AtomicLong:原子更新长整型
* 原子更新数组：
* 原子更新引用：
* 原子更新字段：
 *
 */
public class AtomicDemo1 {
    
    
    public static void main(String[] args) {
        testAtomicInteger();
    
//        testAtomicBoolean();
    }
    
    private static void testAtomicBoolean() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(true);
        System.out.println(atomicBoolean.get());
        System.out.println(atomicBoolean.getAndSet(false));
        System.out.println(atomicBoolean.get());
    }
    
    private static void testAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger();
//        atomicInteger.addAndGet(1231);
//        atomicInteger.addAndGet(1);
        atomicInteger.getAndIncrement();
        atomicInteger.compareAndSet(1,100000);
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
    }
}
