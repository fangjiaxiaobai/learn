package demo3_abstractFactory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class TopFactory implements IFactory {
    @Override
    public ICar createCar() {
        return new TopCar();
    }
    
    @Override
    public IBus createBus() {
        return new TopBus();
    }
}
