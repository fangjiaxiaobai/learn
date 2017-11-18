package String.demo4;

import java.util.Hashtable;

/**
 * @author fangxiaobai
 * @date 2017/11/17 17:44.
 * @description HashTableDemo
 */
public class HashTableDemo {
    
    public static void main(String[] args) {
        Hashtable<String ,String> hashtable = new Hashtable <>();
        hashtable.put("fangxiaobai","fangxiaobai");
        hashtable.put("wangsu","wangsu");
        System.out.println(hashtable);
    }
    
}
