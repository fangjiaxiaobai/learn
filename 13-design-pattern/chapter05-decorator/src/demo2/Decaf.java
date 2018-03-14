package demo2;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class Decaf extends Coffee {
    
    public Decaf(){
        setDescription("脱颖咖啡");
        setPrice(10);
    }
    
    @Override
    public int cost() {
        return super.getPrice();
    }
}
