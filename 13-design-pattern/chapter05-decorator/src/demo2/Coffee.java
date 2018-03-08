package demo2;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public abstract class Coffee implements Drink {
    
    private int price;
    
    private String description;
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price=price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description=description;
    }
    
    @Override
    public int cost() {
        return getPrice();
    }
}
