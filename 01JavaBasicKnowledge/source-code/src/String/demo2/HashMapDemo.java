package String.demo2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author fangxiaobai
 * @date 2017/11/16 19:37.
 * @description HashMapDemo
 */
public class HashMapDemo {
    
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1","123");
        hashMap.put("2","123");
    
        Set set = hashMap.keySet();
        Set <Map.Entry <String, String>> entries = hashMap.entrySet();
    
        for(Map.Entry <String, String> entry : entries) {
        }
    
        for(Object o : set) {
            
        }
    }
    
}
