/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class StrategyTest {
    public static void main(String[] args) {
        String  exp = "2+8";
        ICalculator calculator = new Plus();
        System.out.println(calculator.calculator(exp));
        
        String  exp1 = "2-8";
        ICalculator minus = new Minus();
        System.out.println(minus.calculator(exp1));
        
        String  exp2 = "2*8";
        ICalculator multiply = new Multiply();
        System.out.println(multiply.calculator(exp2));
    }
}
