/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/9
 */
public class AbstractCalculator {
    
    /**
     * 按格式分割表达式
     * @param exp 要分割的表达式
     * @param opt 分割规则。
     * @return
     */
    public int[] split(String exp,String opt){
        String[] array = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
    
}
