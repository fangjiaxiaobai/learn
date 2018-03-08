package demo1_chess;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/6
 */
public class DemoTest {
    public static void main(String[] args) {
        IgoChessman black1,black2,black3,white1,white2,white3;
//        IgoChessmanFactory factory;
    
        IgoChessmanFactory factory=IgoChessmanFactory.getInstance();
    
        black1=factory.getIgoChessman("b");
        black2=factory.getIgoChessman("b");
        black3=factory.getIgoChessman("b");
    
        System.out.println("判断黑色棋子是否相等" + (black1 == black2));
    
        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("判断白色棋子是否相等" + (white1 == white2));
    
        
    }
}
