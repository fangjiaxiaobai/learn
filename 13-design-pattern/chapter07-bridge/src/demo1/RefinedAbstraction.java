package demo1;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class RefinedAbstraction extends Abstraction {
    private Implementor implementor;
    
    @Override
    protected void opertion() {
        super.getImplementor().operation();
    }
}
