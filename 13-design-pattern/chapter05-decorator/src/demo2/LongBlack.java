package demo2;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class LongBlack extends Coffee {
    
    public LongBlack(){
        setDescription("热咖啡");
        setPrice(23);
    }
    
    @Override
    public int cost() {
        return getPrice();
    }
}
