/**
 *
 *  模板方法模式：
 *         ·和 chapter8，策略模式都是父类子类之间的关系的。，继承关系。
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public abstract class AbstractCalculator {
    
    public final int calculate(String exp,String opt){
        int array[] = split(exp,opt);
        return calculate(array[0],array[1]);
    }
    
     public abstract int calculate(int num1,int num2);
    
    public int[] split(String exp,String opt){
            String[] array=exp.split(opt);
            int arrayInt[] = new int[2];
            arrayInt[0] = Integer.parseInt(array[0]);
            arrayInt[1] = Integer.parseInt(array[1]);
            return arrayInt;
    }
    
}
