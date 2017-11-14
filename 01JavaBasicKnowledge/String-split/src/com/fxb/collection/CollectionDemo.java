package com.fxb.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @create by: wangxiyue on 2017/7/13 14:06.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class CollectionDemo {
    public static void main(String[] args){
        test1();
    }

    public static void test1(){

         Collection<String> collection= new ArrayList<String>();

         collection.add("test1");
         collection.add("test2");
         collection.add("test3");
         collection.add("test4");



        System.out.println(collection);
    }



}


