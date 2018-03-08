package demo1_chess;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/6
 */
public abstract class IgoChessman {
    
    public abstract String getColor();
    
    public void display(){
        System.out.println("棋子的颜色是 "+this.getColor());
    }
    
}
