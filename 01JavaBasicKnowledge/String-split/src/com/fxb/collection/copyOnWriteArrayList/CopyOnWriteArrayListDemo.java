package com.fxb.collection.copyOnWriteArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @create by: wangxiyue on 2017/7/13 17:39.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args){

//        List <Integer> list=new ArrayList <>(); //死掉
//        LinkedList<Integer> list = new LinkedList <>(); //死掉
        Vector<Integer> list = new Vector <>();  //死掉
//        CopyOnWriteArrayList list = new CopyOnWriteArrayList();  //没有问题
        for (int i=0; i < 10000; i++) {
            list.add(i);
        }

        T1 t1=new T1(list);
        T2 t2=new T2(list);
        t1.start();
        t2.start();
    }
}
