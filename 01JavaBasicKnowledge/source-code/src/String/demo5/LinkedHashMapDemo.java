package String.demo5;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fangxiaobai
 * @date 2017/11/18 9:27.
 * @description LinkedHashMap
 */
public class LinkedHashMapDemo {
    
    public static void main(String[] args) {
        LinkedHashMap<String ,String > demo1 = new LinkedHashMap <>(11,.75f,false);
        LinkedHashMap<String ,String > demo2 = new LinkedHashMap <>(11,.75f,true);
    
    
        demo1.put("4","1");
        demo1.put("3","1");
        demo1.put("2","1");
        demo1.put("1","1");
        demo1.get("4");
        demo1.get("3");
    
        demo2.put("4","1");
        demo2.put("3","1");
        demo2.put("2","1");
        demo2.put("1","1");
        
        demo2.get("4");
        demo2.get("3");
    
    
        Iterator <Map.Entry <String, String>> iterator = demo1.entrySet().iterator();
        for(;iterator.hasNext();){
            String key = iterator.next().getKey();
            System.out.print(key+",");
        }
        System.out.println();
        iterator = demo2.entrySet().iterator();
        for(;iterator.hasNext();){
            String key = iterator.next().getKey();
            System.out.print(key+",");
        }
        System.out.println();
    
    }
    
    
    
    
}
