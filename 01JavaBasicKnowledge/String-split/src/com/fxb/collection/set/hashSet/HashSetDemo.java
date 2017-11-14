package com.fxb.collection.set.hashSet;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @create by: wangxiyue on 2017/7/14 10:42.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class HashSetDemo {
    private static HashSet<String> set = new HashSet <>();
    private static HashSet<Person> set2 = new HashSet <>();
    public static void main(String[] args){
        init2();
        ergodic(set2);
    }

    public static void init(){
        set.add("床前明月光");
        set.add("疑是地上霜");
        set.add("举头望明月");
        set.add("低头思故乡");
    }

    public static void init2(){
        set2.add(new Person("wangxiyue","nan"));
        set2.add(new Person("yuchunmeng","nv"));
        set2.add(new Person("yuchunmeng2","nv"));
        set2.add(new Person("yuchunmeng2","nvnvnvnv"));
    }

    public static void ergodic(HashSet set){
        Iterator  iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static class Person {
        private String name;
        private String sex;
        public Person(String name,String sex){
            this.name = name;
            this.sex = sex;
        }

        @Override
        public String toString(){
            return "Person{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}
