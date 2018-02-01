package demo2_factory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class MiddleCarFactory implements IFactory {
    @Override
    public ICar create() {
        return new MiddleCar();
    }
}
