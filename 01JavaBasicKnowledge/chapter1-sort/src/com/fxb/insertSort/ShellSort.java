package com.fxb.insertSort;

import com.fxb.commons.utils.Print;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/11
 */
public class ShellSort {
    
   static int []arr = {2,3,1,4,5,6,9,8,7,0};
    
    
    public static void main(String[] args) {
        sort();
    }
    
    private static void sort() {
        for(int gap = arr.length>>1;gap>0;gap=gap>>1){
            for(int i = gap;i<arr.length;i++){
                for(int j=i-gap;j>=0&&arr[j]<arr[j+gap];j-=gap){
                    int temp = arr[j];
                    arr[j] = arr[j+gap];
                    arr[j+gap] = temp;
                    System.out.println("gap="+gap+",i="+i+",j="+j);
                    Print.println(arr);
                }
            }
        }
        Print.println(arr);
    }
    
    
    
}
