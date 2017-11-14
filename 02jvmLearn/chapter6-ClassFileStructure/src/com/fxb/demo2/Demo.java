package com.fxb.demo2;

/**
 * @author fangxiaobai on 2017/10/11 14:36.
 * @description
 */
public class Demo {
    
    public int inc(){
        int x;
        
        try{
            x = 1 ;
//            int i = 1/0;
            return x;
        }catch(Exception e) {
            x = 2;
            return x;
        }finally {
            x = 3;
            return 3;
        }
    }
    
    public static void main(String[] args) {
        int inc = new Demo().inc();
        System.out.println(inc);
    }
}

/**
 *   异常表解释：
 *
 */

/**
 *  public int inc();
 flags: ACC_PUBLIC
 Code:
 stack=1, locals=5, args_size=1
 0: iconst_1  // try块中 x=1
 1: istore_1
 2: iload_1  // 保存x到returnValue中，此时x=1
 3: istore_2  // catch块中x=2
 4: iconst_3 // finally x=3
 5: istore_1
 6: iload_2  // 将returnValue中的值放入栈顶，准备给ireturn返回。
 7: ireturn
 8: astore_2  //  给catch中定义Exception e赋值，存储Slot2中
 9: iconst_2  // catch块中的x=2
 10: istore_1
 11: iload_1  // 保存x到returnValue中，此时x=2
 12: istore_3
 13: iconst_3
 14: istore_1
 15: iload_3
 16: ireturn
 17: astore        4
 19: iconst_3
 20: istore_1
 21: aload         4
 23: athrow
 Exception table:
 from    to  target type  // 三条异常记录，代表代码执行路径。
 0     4     8   Class java/lang/Exception
 0     4    17   any
 8    13    17   any
 17    19    17   any
 LineNumberTable:
 line 13: 0
 line 14: 2
 line 19: 4
 line 15: 8
 line 16: 9
 line 17: 11
 line 19: 13
 StackMapTable: number_of_entries = 2
 frame_type = 72 // same_locals_1_stack_item
          stack = [ class java/lang/Exception ]
        frame_type = 72 // same_locals_1_stack_item
        stack = [ class java/lang/Throwable ]
        
        
 */
 