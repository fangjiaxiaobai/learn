package com.fxb.gc.demo2;

/**
 * @author 方小白 on 2017/10/9 9:51.
 * @description
 *
 *      演示   使用finalize()方法避免被回收。
 *
 *
 *          代码中有两段完全相同的代码片段，执行结果确实一次成功，一次失败。
 *    原因是：任何一个对象的finalize()方法都只会被系统自动调用一次，如果对象面临下一次回收，
 *    她的finalize()方法不会被再次执行。
 *
 *
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    
    public void isAlive(){
        System.out.println("yes, i am still alive...");
    }
    
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(" finalize method executed ");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
    
    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        
        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
    
        // 因为finalizer方法优先级很低，暂停0.5秒，以等待它。
        Thread.sleep(500);
        
        if(null!=SAVE_HOOK){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println(" i am dead");
        }
        
        // 以下代码和上面的代码完全相同，但是这次自救却失败了。
        SAVE_HOOK = null;
        System.gc();
    
        Thread.sleep(500);
        
        if(null!=SAVE_HOOK){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println(" i am dead");
        }
        
        
        
    }
}
