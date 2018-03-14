package demo1;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class MySubject extends AbstractSubject implements Subject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
