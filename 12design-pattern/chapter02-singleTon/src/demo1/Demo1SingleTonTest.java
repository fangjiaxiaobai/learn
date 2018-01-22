package demo1;

/**
 * @author fangjiaxiaobai
 * @date 2018/1/7
 */
public class Demo1SingleTonTest {
    public static void main(String[] args) {
        Demo1SingleTon instance = Demo1SingleTon.getInstance();
        Demo1SingleTon instance1 = Demo1SingleTon.getInstance();
        System.out.println(instance == instance1);
    }
}
