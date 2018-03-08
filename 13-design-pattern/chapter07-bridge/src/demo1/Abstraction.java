package demo1;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public abstract class Abstraction {
    
    private Implementor implementor;
    
    public Implementor getImplementor() {
        return implementor;
    }
    
    public void setImplementor(Implementor implementor) {
        this.implementor=implementor;
    }
    
    protected void opertion(){
        implementor.operation();
    }
}
