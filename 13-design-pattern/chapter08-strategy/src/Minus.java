/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class Minus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculator(String exp) {
        int arrayInt[] = split(exp, "-");
        return arrayInt[0]-arrayInt[1];
    }
}
