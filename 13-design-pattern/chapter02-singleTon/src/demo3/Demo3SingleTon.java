package demo3;

/**
 * @author fangjiaxiaobai
 * @date 2018/1/7
 *
 *     这种方式的实现也并非是完美的。
 *     如果创建对象的时候就出错了，那么对象就永远得不到创建了。
 *     也有人将创建对象和getInstance()分开，单独在创建对象的时候加锁。见Demo4
 *
 */
public class Demo3SingleTon {
    private Demo3SingleTon(){}
    
    private static class Demo3SingleTonHolder{
      public static Demo3SingleTon singleTon = new Demo3SingleTon();
    }
    
    public static Demo3SingleTon getInstance(){
        return Demo3SingleTonHolder.singleTon;
    }
}
