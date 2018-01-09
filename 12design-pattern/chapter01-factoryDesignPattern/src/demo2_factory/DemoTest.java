package demo2_factory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class DemoTest {
    public static void main(String[] args) {
        TopCarFactory topCarFactory = new TopCarFactory();
        topCarFactory.create();
    
        MiddleCarFactory middleCarFactory = new MiddleCarFactory();
        middleCarFactory.create();
    
        LowCarFactory lowCarFactory = new LowCarFactory();
        lowCarFactory.create();
    }
}
