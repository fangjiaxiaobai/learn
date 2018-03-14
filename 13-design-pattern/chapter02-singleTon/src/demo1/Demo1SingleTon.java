package demo1;

/**
 * @author fangjiaxiaobai
 * @date 2018/1/7
 *      1. 创建一个对象实例。
 *      2. 私有化实例方法
 *      3. 提供一个public方法使其可以获取实例，并且保证实例唯一。
 *  注:这种写法是线程不安全的。
 *      如果是多线程的程序，就会很容易出现问题。
 *  所以在多线程程序中是使用单例模式，见demo2
 *
 *      懒汉式单例设计模式
 *
 */
public class Demo1SingleTon {
    
    private static Demo1SingleTon singleTon;
    
    private Demo1SingleTon(){
    
    }
    
    public static Demo1SingleTon getInstance(){
        if(null==singleTon){
            singleTon = new Demo1SingleTon();
        }
        return singleTon;
    }
    
}
