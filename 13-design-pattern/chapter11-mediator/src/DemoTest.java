/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/22
 */
public class DemoTest {
    
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Collugue collugueA = new CollugueA("A" ,mediator );
        Collugue collugueB = new CollugueA("B",mediator);
        collugueA.sendMsg(" Do you have time in the afternoon and drink tea together?");
        collugueB.sendMsg(" That's really great. ");
    }
}
