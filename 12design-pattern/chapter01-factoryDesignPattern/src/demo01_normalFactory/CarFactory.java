package demo01_normalFactory;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/29
 */
public class CarFactory {
    private static final String TYPE_TOP = "top";  //高配
    private static final String TYPE_MIDDLE = "mid"; //中配
    private static final String TYPE_LOW = "low";
    
    public static ICar create(String type){
        ICar car = null;
        if (TYPE_TOP.equals(type)){
            car = new TopCar();
        }else if(TYPE_MIDDLE.equals(type)){
            car = new MiddleCar();
        }else if(TYPE_LOW.equals(type)){
            car = new LowCar();
        }
        return car;
    }
    
}
