/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class DemoTest {
    
    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator plus=new Plus();
        System.out.println(plus.calculate(exp, "\\+"));
    }
}
