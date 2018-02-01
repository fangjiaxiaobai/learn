package demo3_abstractFactory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class DemoTest {
    public static void main(String[] args) {
        LowFactory lowFactory = new LowFactory();
        lowFactory.createBus();
    }
}
