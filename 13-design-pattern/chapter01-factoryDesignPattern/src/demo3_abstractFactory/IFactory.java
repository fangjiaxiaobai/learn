package demo3_abstractFactory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public interface IFactory {
    
    ICar createCar();
    
    IBus createBus();
}