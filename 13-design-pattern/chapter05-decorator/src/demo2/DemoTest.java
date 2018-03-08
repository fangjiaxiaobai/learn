package demo2;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/7
 */
public class DemoTest {
    public static void main(String[] args) {
        LongBlack longBlack = new LongBlack();
        System.out.println("order1 price" + longBlack.getPrice());
        System.out.println("order1 description" + longBlack.getDescription());
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        Coffee order;
        order = new Decaf();
        order = new CoffeeDecorator(order);
        order = new CoffeeDecorator( order);
        System.out.println(order.cost());
        System.out.println(order.getDescription());
    }
}
