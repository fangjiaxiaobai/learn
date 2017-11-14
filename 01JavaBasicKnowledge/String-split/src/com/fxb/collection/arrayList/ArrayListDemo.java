package com.fxb.collection.arrayList;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @create by: wangxiyue on 2017/7/13 15:11.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class ArrayListDemo {

   private static List<String> defaultList = null;

    public static void main(String[] args){
//        toSynchronizedList();
        init();
        normalErgodic();
        forEachErgodic();
        iteratorErgodic();
    }

    /**
     * 把ArrayList变成线程安全的List
     */
    public static void toSynchronizedList(){
        ArrayList<String> list = new ArrayList <>();
        List<String> synchronizedList =Collections.synchronizedList(list);
        synchronizedList.add("aa");
        synchronizedList.add("bb");
        synchronizedList.add("cc");
        synchronizedList.add("dd");
        for (String s : synchronizedList) {
            System.out.println(s);
        }
    }

    /**
     * 初始化default，
     */
    public static void init(){
        defaultList = new ArrayList <>();
        defaultList.add("床前明月光");
        defaultList.add("疑是地上霜");
        defaultList.add("举头望明月");
        defaultList.add("低头思故乡");
    }

    /**
     * 普通for循环遍历
     */
    public static void normalErgodic(){
        System.out.println();
        for (int i=0; i < defaultList.size(); i++) {
            System.out.println(defaultList.get(i));
        }
    }

    /**
     * foreach 循环遍历
     */
    public static void forEachErgodic(){
        System.out.println();
        for (String s : defaultList) {
            System.out.println(s);
        }
    }

    /**
     * 迭代器遍历
     */
    public static void iteratorErgodic(){
        System.out.println();
        Iterator <String> iterator=defaultList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
