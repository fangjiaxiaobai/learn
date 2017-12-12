package com.fxb.swapSort;

import com.fxb.commons.utils.Print;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/1
 */
public class BubbleSort {

    static int []arr = {2,3,1,4,5,6,9,8,7,0};

    public static void main(String[] args) {
//        bubbleSort(arr);
        bubbleSort2(arr);
    }


    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0;j<arr.length-i-1; j++) {
                if(arr[j]<arr[j+1]){
//                    swap();
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        Print.print(arr);
    }


    /**
     * 优化后。
     * @param arr
     */
    public static void bubbleSort2(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;
            for (int j = 0;j<arr.length-i-1; j++) {
                if(arr[j]<arr[j+1]){
//                    swap();
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        Print.print(arr);
    }



}
