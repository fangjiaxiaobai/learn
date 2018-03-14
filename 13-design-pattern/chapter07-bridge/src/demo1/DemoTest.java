package demo1;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class DemoTest {
    
    public static void main(String[] args) {
         Abstraction abstraction = new RefinedAbstraction();
         
         abstraction.setImplementor(new ConcreteImplementorA());
         abstraction.opertion();
         
         abstraction.setImplementor(new ConcreteImplementorB());
         abstraction.opertion();
    }
    
}
