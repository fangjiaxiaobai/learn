package demo2;

import demo1.Demo1SingleTon;

/**
 * @author fangjiaxiaobai
 * @date 2018/1/7
 *      演示多线程情况下的单例模式。
 *
 *
 *      加上了synchronized关键字之后，程序好像是安全了。尽管在原来的基础上还提升了效率。
 *      但是仔细查看还是会出现问题：
 *          由于singleTon = new Demo2SingleTon是分两步执行的，并且jvm的优化机制，并不能保证其二者的执行顺序。
 *      当出现这种请况，错误就产生了：
 *          假设两个线程：
 *              1.a和b同时进入了第一个if语句，
 *              2.a先进入synchronized同步块，jvm优先分配了一个空白的区域赋给singleTon，但是这时jvm还没有实例化Demo2SingleTon。
 *              3.a执行完，出去synchronized同步块。
 *              4.b这个时候发现，singleTon不为空了，直接返回，当b使用的时候，就会报错了。
 *      这种优化方式将demo3
 *          将对象用内部类将其持有化。
 *
 *
 */
public class Demo2SingleTon {

    private static Demo2SingleTon singleTon;
    
    private Demo2SingleTon(){
    
    }
    
    /**
     *  这种方式会在性能上有所下降
     *  每次调用getInstance方式，都会加锁。
     * @return
     */
//    public static synchronized Demo2SingleTon getInstance(){
//        if (null!=singleTon) {
//            singleTon = new Demo2SingleTon();
//        }
//        return singleTon;
//    }
//
    
    /**
     *  双重校验锁的方式
     *  这种方式，只是会在创建的对象的时候加锁，也就是第一次创建对象的时候加锁。
     * @return
     */
    public static Demo2SingleTon getInstance(){
        if(null!=singleTon){
            synchronized (singleTon){
                if(null!=singleTon) {
                    singleTon = new Demo2SingleTon();
                }
            }
        }
        return singleTon;
    }


}
