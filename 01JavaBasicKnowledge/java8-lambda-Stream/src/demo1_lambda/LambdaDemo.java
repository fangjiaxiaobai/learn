package demo1_lambda;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fangxiaobai
 * @date 2017/11/18 16:57.
 * @description LambdaDemo
 */
public class LambdaDemo {
    
    public static void main(String[] args) {
//        test1();
    
//        test2();

//        test3();
    
//        test4();
    
        List<String> names = Arrays.asList("java","C++","C","python","javaScript");
        names.stream().map(item -> item.toUpperCase());
        /*
        map(new Function(){
          public R apply(T item){
            return item.toUpperCase();
          }
        })
        */
    }
    
    private static void test4() {
        List<String> names = Arrays.asList("java","C++","C","python","javaScript");
        names.stream().forEach(System.out::println);
    }
    
    private static void test3() {
        List<String> names = Arrays.asList("java","C++","C","python","javaScript");
        Predicate<String> j = item -> item.startsWith("j");
        Predicate <String> l = item -> item.length() == 4;
        names.stream().filter(j.and(l)).forEach(System.out::println);
    }
    
    private static void test2() {
        List<String> names = Arrays.asList("java","C++","C","python","javaScript");
        names.stream().filter(item->item.startsWith("j")).forEach(System.out::println);
    }
    
    
    private static void test1() {
        TreeSet<String> treeSet = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        
        treeSet.add("fangxiaobai");
        treeSet.add("wangsu");
        treeSet.add("fanghengyu");
        
        TreeSet<String> treeSet1 = new TreeSet <>(( o1, o2) ->
            o1.compareToIgnoreCase(o2)
        );
        
        treeSet1.add("fangxiaobai");
        treeSet1.add("wangsu");
        treeSet1.add("fanghengyu");
        
        System.out.println(treeSet);
        System.out.println(treeSet1);
        
        // demo2
        List<String> names = new ArrayList<>();
        names.add("Fangxiaobai");
        names.add("FangHengyu");
        names.add("WangSu");
        List<String> lowercaseName = names.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowercaseName);
        
        
        //demo3
        ArrayList <String> arrayList = new ArrayList <>();
        arrayList.add(" xiaobai ");
        arrayList.add(" susu  ");
        for(String s : arrayList) {
            Stream.of(arrayList).map(item->s.length()+"   ").forEach(System.out::print);
            Stream.of(arrayList).map(item->s.trim()).forEach(System.out::println);
        }
        
        
        ///demo4
        Comparator <Integer> compare = Integer::compare;
    }
    
    
}
