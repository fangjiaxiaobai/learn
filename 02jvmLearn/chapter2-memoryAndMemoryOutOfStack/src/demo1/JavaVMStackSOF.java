package demo1;

/**
 * @author 方小白 on 2017/9/29 11:03.
 * @description
 *
 *         演示 StackOverflowError异常，异常出现是输出的栈深度相应缩小。
 *
 *         实验结果：
 *          在单个线程下，无论是栈帧太大，还是虚拟机栈容量小，当内存无法分配的时候，
 *          虚拟机抛出的都是StackOverflowError异常、
 *          如果非单线程的情况下，通过不断建立线程的方式倒是可以产生内存溢出异常。但是 这样产生的内存溢出异常和栈空间是否足够大并不存在任何联系。
 *          或者准确的说，在这种情况下，给每个线程的栈分配的内存越大，反而越容易产生内存溢出异常。
 *
 *
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    
    public void stackLeak(){
        stackLength ++ ;
        stackLeak();
    }
    
    public static void main(String[] args) throws  Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch(Throwable e){
            System.out.println("stack Length:"+oom.stackLength);
            throw e;
        }
    }
}
