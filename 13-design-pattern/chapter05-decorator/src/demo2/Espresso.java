package demo2;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class Espresso extends Coffee {
    
    public Espresso(){
        setDescription("浓咖啡");
        setPrice(123);
    }
    
    @Override
    public int cost() {
        return getPrice();
    }
}
