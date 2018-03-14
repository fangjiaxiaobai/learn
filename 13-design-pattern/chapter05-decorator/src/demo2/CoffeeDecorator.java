package demo2;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class CoffeeDecorator extends Coffee {
    
    private Coffee coffee;
    
    public CoffeeDecorator(Coffee drink){
        this.coffee = drink;
    }
    
    @Override
    public int cost() {
        return coffee.cost() + super.cost();
    }
    
    public String getDescription(){
        return super.getDescription()+"&&"+this.coffee.getDescription();
    }
    
}
