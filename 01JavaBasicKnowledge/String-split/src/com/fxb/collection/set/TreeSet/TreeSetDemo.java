package com.fxb.collection.set.TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @create by: wangxiyue on 2017/7/14 10:56.
 * @ClassName:
 * @userfor:
 * @description:
 */
public class TreeSetDemo {
    private static TreeSet<String> set = new TreeSet <>();
    private static TreeSet<Person> set2 = new TreeSet <>();
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
        set2.add(new Person("asdf1","asdfas"));
        set2.add(new Person("asdf2","asdfas"));
        set2.add(new Person("asdf3","asdfas"));
        set2.add(new Person("asdf4","asdfas"));
        set2.add(new Person("asdf5","asdfas"));
    }

    public static void ergodic(TreeSet set){
        Iterator iterator=set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    private static class Person implements Comparable<Person> {
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

        @Override
        public int compareTo(Person o){
            return o.name.equals(name)?0:1;
        }
    }
}
