package com.fxb.collection.linkedListDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @create by: wangxiyue on 2017/7/13 16:35.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class LinkedListDemo {
    public static void main(String[] args){
        testMain();
    }


    private static int SIZE=111111;

    private static void loopList(List <Integer> list){

        long startTime=System.currentTimeMillis();
        for (int i=0; i < list.size(); i++) {
            list.get(i);
        }
        System.out.println(list.getClass().getSimpleName() + "使用普通for循环遍历时间为" +
                (System.currentTimeMillis() - startTime) + "ms");

        startTime=System.currentTimeMillis();
        for (Integer i : list) {

        }
        System.out.println(list.getClass().getSimpleName() + "使用foreach循环遍历时间为" +
                (System.currentTimeMillis() - startTime) + "ms");
    }

    //测试ArrayList和LinkedList的遍历效率
    public static void testMain(){
        List <Integer> arrayList=new ArrayList <>(SIZE);
        List <Integer> linkedList=new LinkedList <Integer>();

        for (int i=0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        loopList(arrayList);
        loopList(linkedList);
        System.out.println();
    }
}
