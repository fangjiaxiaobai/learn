package com.fxb.collection.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @create by: wangxiyue on 2017/7/13 18:15.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class HashMapDemo {
    private static HashMap<Integer,String> hashMap=new HashMap();

    public static void main(String[] args){
        init();
        ergodic();
        ergodic2();
    }

    /**
     * 初始化hashMap
     */
    public static void init(){
        hashMap.put(1, "asdf");
        hashMap.put(2, "asdf");
        hashMap.put(3, "asdf");
        hashMap.put(4, "asdf");
        hashMap.put(5, "asdf");
        hashMap.put(6, "asdf");
        hashMap.put(7, "asdf");
    }


    //遍历方式：

    public static void ergodic(){
        System.out.println();
        Set<Map.Entry<Integer,String>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void ergodic2(){
        System.out.println();
        Set <Integer> keys=hashMap.keySet();
        Iterator <Integer> iterator=keys.iterator();
        while (iterator.hasNext()) {
            Integer key=iterator.next();
            String value=hashMap.get(key);
            System.out.println(key+"--"+value);
        }
    }

}


