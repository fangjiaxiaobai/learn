package com.fxb.collection.hashMap.LinkedHashMap;

import java.util.LinkedHashMap;

/**
 * @create by: wangxiyue on 2017/7/14 10:35.
 * @ClassName:
 * @userfor:
 *
 * @description:
 */
public class LinkedHashMapDemo {
    public static java.util.LinkedHashMap linkedHashMap =new LinkedHashMap();
    public static void main(String[] args){
        init();
    }

    public static void init(){
        linkedHashMap.put("1","床前明月光");
        linkedHashMap.put("2","疑是地上霜");
        linkedHashMap.put("3","举头望明月");
        linkedHashMap.put("4","低头思故乡");
    }

    //遍历方法和HashMap一致。
    public static void ergodic(){
    }
}
