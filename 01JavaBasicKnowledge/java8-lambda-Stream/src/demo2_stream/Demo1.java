package demo2_stream;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author fangxiaobai
 * @date 2017/11/20 11:17.
 * @description Demo1
 */
public class Demo1 {
    
    
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test3_1();
//        test3_3();
//        test4();
//        test5();
//        test6();
    
//        test7();
    
//        test8();
    
//        test9();
    
        //12-2,13-2,14-4,15-5,16-3
        Stream <Integer> integerStream = Stream.of(12, 13, 14, 15, 16, 12, 13, 14, 15, 16, 14, 14, 15, 15, 16, 16, 13, 15);
    }
    
    private static void test9() {
        boolean b = Stream.of(12, 32, 23, 31, 32, 17, 19).mapToInt(Integer::intValue).allMatch(item -> item > 10);
        System.out.println(b);
        boolean b1 = Stream.of(12, 32, 23, 31, 32, 17, 19).mapToInt(Integer::intValue).anyMatch(item -> item < 18);
        System.out.println(b1);
        boolean b2 = Stream.of(12, 32, 23, 31, 32, 17, 19).mapToInt(Integer::intValue).anyMatch(item -> item < 0);
        System.out.println(b2);
    }
    
    private static void test8() {
        ArrayList<String> names = new ArrayList();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.stream().limit(2).sorted((p1,p2)->p1.compareTo(p2)).forEach(System.out::println);
    }
    
    private static void test7() {
        String reduce = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(reduce);
        
        Integer reduce1 = Stream.of(2, 3, 3, 4, 54).reduce(3, Integer::min);
        System.out.println(reduce1);
        
        int sum = Stream.of(2, 3, 6, 54, 8).mapToInt(i -> i).sum();
        System.out.println(sum);
    }
    
    private static void test6() {
        Stream<List<Integer>> lists = Stream.of(
                Arrays.asList(1),
                Arrays.asList(null, null, 3),
                Arrays.asList(1, 3, 3, 4, 4, 5)
        );
        lists.flatMap(child->child.stream()).forEach(item-> Optional.ofNullable(item).ifPresent(System.out::println));
//        lists.flatMap(childList -> childList.stream()).forEach(System.out::println);
    }
    
    private static void test5() {
        Stream<String> stream = Stream.of("fangxiaobai", "wangsu", "fanghengyu");
        stream.map(String::toUpperCase).forEach(System.out::println);
    }
    
    private static void test4() {
        Stream<String> stream = Stream.of("1", "2", "3", "4", null, "1", "2", "3", "5", "6","7","8");
        
        int sum = stream.filter(num -> num != null).distinct().map(item -> Integer.parseInt(item)).mapToInt(num -> num * 2).peek(System.out::println).skip(4).sum();
        System.out.println(sum);
    }
    
    private static void test3_3() {
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10).forEach(System.out::println);
    }
    
    private static void test3_1() {
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(10).forEach(System.out::println);
    }
    
    private static void test3() {
        Stream<Double> generate = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });
        generate.map(item->item).limit(10).forEach(System.out::println);
    }
    
    private static void test2() {
        Stream<String> stringStream = Stream.of("1", "2", "3", "4");
       stringStream.forEach(System.out::println);
    }
    
    
    private static void test1() {
        List<Integer> nums = new ArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(null);
        nums.add(4);
        nums.add(null);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println(count);
    }
    
}
