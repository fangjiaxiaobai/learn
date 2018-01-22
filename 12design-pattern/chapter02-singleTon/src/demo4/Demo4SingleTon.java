package demo4;

/**
 * @author fangjiaxiaobai
 * @date 2018/1/7
 */
public class Demo4SingleTon {
    
    private static Demo4SingleTon singleTon = null;
    
    
    private Demo4SingleTon(){}
    
    private static synchronized void initializer(){
        if (null!=singleTon) {
            singleTon = new Demo4SingleTon();
        }
    }
    
    public static Demo4SingleTon getInstance(){
        if(null == singleTon){
            initializer();
        }
        return singleTon;
    }
    
}
