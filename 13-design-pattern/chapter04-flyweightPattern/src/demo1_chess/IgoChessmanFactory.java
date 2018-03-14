package demo1_chess;

import java.util.Hashtable;

/**
 * @author fangjiaxiaobai@163.com
 * @date 2018/3/6
 */
public class IgoChessmanFactory {
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable<String , IgoChessman> ht ;
    
    private IgoChessmanFactory(){
        ht = new Hashtable();
        IgoChessman black,white;
        black = new BlackIgoChess();
        ht.put("b",black);
        white = new WirteIgoChess();
        ht.put("w",white);
    }
    
    public static IgoChessmanFactory getInstance(){
        return instance;
    }
    
    public IgoChessman getIgoChessman(String color){
        return (IgoChessman) ht.get(color);
    }
}
