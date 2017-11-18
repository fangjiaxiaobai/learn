package String.demo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author fangxiaobai
 * @date 2017/11/13 19:59.
 * @description Demo1
 */
public class Demo1 {
    
    public static void main(String[] args) {
        String str = "abcdefghigk";
        int i = str.codePointAt(4);
        System.out.println(i);
    
        LinkedList<String> list = new LinkedList <>();
        list.add("1231");
        list.add("1232");
        list.add("1233");
        list.add("1234");
        list.add("1235");
        list.add("1236");
        list.add("1237");
    
        for(String s : list) {
            
        }
        String s = list.get(1);
    
    }
    
}
