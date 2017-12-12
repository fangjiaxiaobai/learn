package com.fxb.swapSort;

import com.fxb.commons.utils.Print;

/**
 * @author fangjiaxiaobai
 * @date 2017/12/1
 *
 *      快速排序在元素较少的时候建议使用插入排序，因为快排效率较低。
 *
 */
public class QuicklySort {

    private static int []arr = {2,3,1,4,5,6,9,8,7,0};

    public static void main(String[] args) {
        quicklySort(arr,0,9);
        Print.print(arr);
    }

    private static void quicklySort(int []arr,int low,int high){
        if(low < high){
            int privotLoc = partition(arr,low,high);
            quicklySort(arr,low,privotLoc-1);
            quicklySort(arr,privotLoc+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int privotKey = arr[low];
        while(low<high){
            while(low<high && arr[high]>=privotKey){
                --high;
            }
            if(low<high){
                arr[low] = arr[high];
            }
            while(low<high && arr[low]<privotKey){
                ++low;
            }
            if(low<high){
                arr[high] = arr[low];
            }
        }
        arr[high] = privotKey;
        return high;
    }

}
