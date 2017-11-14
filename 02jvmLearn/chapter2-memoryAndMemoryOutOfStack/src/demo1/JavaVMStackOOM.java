package demo1;

/**
 *  vm args: -Xss2M
 *
 * @author 方小白 on 2017/9/29 11:18.
 * @description
 *
 *  演示创建线程导致内存溢出异常
 *
 *
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while(true){
            
        }
    }
    
    public void stackLeakByThread(){
        while(true) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            t.start();
        }
    }
    
    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
