/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/22
 */
public class CollugueA implements Collugue {
    
    private String name;
    private Mediator mediator;
    
    public CollugueA(String name, Mediator mediator) {
        this.name=name;
        this.mediator=mediator;
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    public void sendMsg(String msg){
        mediator.contact(msg,this);
    }
    
    
}
