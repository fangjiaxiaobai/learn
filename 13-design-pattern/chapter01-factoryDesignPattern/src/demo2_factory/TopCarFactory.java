package demo2_factory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class TopCarFactory implements IFactory {
    @Override
    public ICar create() {
        return new TopCar();
    }
}
