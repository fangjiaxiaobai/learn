import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 *
 * AtomicLongFieldUpdater,AtomicIntegerFieldUpdater,AtomicReferenceFieldUpdater
 * 是基于反射的实用工具，可以对指定类的指定volatile字段进行原子更新。
 *  使用这个的约束：
 * 字段必须是volatile类型。
 * 字段的描述类型，是与调用者与操作对象字段的关系一致。调用者能够直接操作对象字段。不能操作父类中的字段。
 * 只能是实例变量，不能是类变量，也就是说不能加static关键字
 * 只能是可修改变量，不能是final变量，因为final的语义就是不可修改。
 * 对于AtomicIntegerFieldUpdater和AtomicLongFieldUpdater只能修改int/long类型的字段。
 * 不能修改其包装类型，如果要修改包装类型就需要使用AtomicReferenceFieldUpdater。
 *
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/20
 */
public class AtomicLongFieldUpdaterDemo {
    
    private volatile long data = 100l;
    private static final AtomicLongFieldUpdater<AtomicLongFieldUpdaterDemo> ATOMIC_LONG_FIELD_UPDATER
        = AtomicLongFieldUpdater.newUpdater(AtomicLongFieldUpdaterDemo.class,"data");
    
    public static void main(String[] args) {
        AtomicLongFieldUpdaterDemo demo=new AtomicLongFieldUpdaterDemo();
        ATOMIC_LONG_FIELD_UPDATER.compareAndSet(demo,demo.getData(),110l);
        System.out.println(demo.getData());
    }
    
    public Long getData() {
        return data;
    }
}
