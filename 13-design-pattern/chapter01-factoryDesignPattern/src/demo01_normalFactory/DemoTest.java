package demo01_normalFactory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 *      工厂设计模式分为三种：
 *          *普通工厂设计模式。
 *          多工厂设计模式。
 *          静态工厂设计模式。
 *
 *
 */
public class DemoTest {
    public static void main(String[] args) {
        CarFactory.create("top");
        CarFactory.create("mid");
        CarFactory.create("low");
    }
}
