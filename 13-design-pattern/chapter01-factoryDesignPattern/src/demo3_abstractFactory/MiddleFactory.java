package demo3_abstractFactory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class MiddleFactory implements IFactory{
    @Override
    public ICar createCar() {
        return new MiddleCar();
    }
    
    @Override
    public IBus createBus() {
        return new MiddleBus();
    }
}
