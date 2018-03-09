package demo1;

/**
 *  具体观察者1
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer  1 has received! ");
    }
}
