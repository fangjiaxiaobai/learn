package demo6;

/**
 * 枚举单例模式
 *  默认枚举实例的创建是线程安全的，并且在任何情况下都是一个单例。
 *  枚举单例的有点就是简单，但是大部分应用开发很少用枚举，可读性不高，不建议使用。
 *  不存在反序列化生成新实例的问题。
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/6
 */
public class SingleTon  {
    
    static SingleTon singleTon = SingleTon.singleTon;
    
    enum singleTon{
        INSTANCE;
    }
    
}
