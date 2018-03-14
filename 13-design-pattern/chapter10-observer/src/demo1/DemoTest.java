package demo1;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class DemoTest {
    public static void main(String[] args) {
        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operation();
    }
}
