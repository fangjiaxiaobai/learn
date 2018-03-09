package demo1;

/**
 * 具体观察者2
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
