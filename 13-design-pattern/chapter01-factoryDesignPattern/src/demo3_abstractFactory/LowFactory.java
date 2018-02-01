package demo3_abstractFactory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class LowFactory implements IFactory {
    public ICar createCar(){
        return new LowCar();
    }
    
    @Override
    public IBus createBus() {
        return new LowBus();
    }
}
