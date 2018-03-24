/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/22
 */
public class ConcreteMediator implements Mediator {
    @Override
    public void contact(String msg, Collugue collugue) {
        System.out.println("hi,my name is "+collugue.getName()+","+msg);
    }
}
