package demo1;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class SourceDecoretor  implements Sourceable {
    
    private Sourceable source ;
    
    public SourceDecoretor(Sourceable source){
        this.source = source;
    }
    
    @Override
    public void method() {
        System.out.println("before source method called");
        this.source.method();
        System.out.println("after source method called");
    }
}
