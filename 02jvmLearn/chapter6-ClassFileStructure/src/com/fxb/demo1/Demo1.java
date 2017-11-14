package com.fxb.demo1;

/**
 * @author fangxiaobai on 2017/10/11 10:33.
 * @description
 */
public class Demo1 {
    
    private int m;
    
    public int inc() {
        return m + 1;
    }
    
    public static int inc2(){
        return 2;
    }
    
}

/**
 * javap -verbose Demo1.class 后的结果：
 */
/*
E:\fxb_myApplication\Learn\jvmLearn\chapter6-ClassFileStructure\src\com\fxb\demo1>javap -verbose Demo1.class
Classfile /E:/fxb_myApplication/Learn/jvmLearn/chapter6-ClassFileStructure/src/com/fxb/demo1/Demo1.class
  Last modified 2017-10-11; size 328 bytes
  MD5 checksum d388a5c51aa993a3ea759328c3262d1c
  Compiled from "Demo1.java"
public class com.fxb.demo1.Demo1
  SourceFile: "Demo1.java"
  minor version: 0
  major version: 51
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:   // 常量池
   #1 = Methodref          #4.#16         //  java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#17         //  com/fxb/demo1/Demo1.m:I
   #3 = Class              #18            //  com/fxb/demo1/Demo1
   #4 = Class              #19            //  java/lang/Object
   #5 = Utf8               m
   #6 = Utf8               I
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               inc
  #12 = Utf8               ()I
  #13 = Utf8               inc2
  #14 = Utf8               SourceFile
  #15 = Utf8               Demo1.java
  #16 = NameAndType        #7:#8          //  "<init>":()V
  #17 = NameAndType        #5:#6          //  m:I
  #18 = Utf8               com/fxb/demo1/Demo1
  #19 = Utf8               java/lang/Object
{
  public com.fxb.demo1.Demo1();
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0

  public int inc();
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1   /// 为什么args_size为1呢？
                                             在任何实例方法中，都可以通过this关键字访问到此方法所属的对象。
                                             实现原理：仅仅是通过javac编译器在编译的时候把对this关键的访问编程对一个普通方法参数的访问。然后再虚拟机调用实例方法是自动传入此参数。
                                             
         0: aload_0
         1: getfield      #2                  // Field m:I
         4: iconst_1
         5: iadd
         6: ireturn
      LineNumberTable:
        line 12: 0

  public static int inc2();
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: iconst_2
         1: ireturn
      LineNumberTable:
        line 16: 0
}





 */