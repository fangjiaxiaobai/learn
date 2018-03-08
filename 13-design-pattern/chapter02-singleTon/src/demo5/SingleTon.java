package demo5;

/**
 * 单例模式的通用写法
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/6
 */
public class SingleTon {
    
    private static final SingleTon single=new SingleTon();
    
    private SingleTon() {
    }
    
    public static SingleTon getInstance() {
        return single;
    }
    
}
