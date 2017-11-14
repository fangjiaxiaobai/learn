import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxiyue on 2017/9/27 17:42.
 * @description
 */
public class StringDemo {
    
    public static void main(String[] args) {
        String str = "abc:def:ghij:klmn:opq:rst";
    
        String[] split = str.split(":", 0);
        System.out.println(toList(split)); // [abc, def, ghij, klmn, opq, rst]
    
        String[] split1 = str.split(":", 1);
        System.out.println(toList(split1));// [abc, def, ghij, klmn, opq, rst]
    
        String[] split2 = str.split(":", 2);
        System.out.println(toList(split2));// [abc, def:ghij:klmn:opq:rst]
    
        String[] split3 = str.split(":", 3);
        System.out.println(toList(split3));// [abc, def, ghij:klmn:opq:rst]
    
        String[] split4 = str.split(":", 4);
        System.out.println(toList(split4));// [abc, def, ghij, klmn:opq:rst]
        
        String[] split5 = str.split(":", 5);
        System.out.println(toList(split5));// [abc, def, ghij, klmn, opq:rst]
        
        String[] split6 = str.split(":", 6);
        System.out.println(toList(split6));// [abc, def, ghij, klmn, opq, rst]
       
    }
    
    public static List<String> toList(String[] splits){
        List<String> list = new ArrayList <>();
        for(String split : splits) {
            list.add(split);
        }
        return list;
    }
}
