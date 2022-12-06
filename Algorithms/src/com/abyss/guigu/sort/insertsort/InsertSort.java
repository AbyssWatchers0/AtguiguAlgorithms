package com.abyss.guigu.sort.insertsort;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-23 20:32
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100000);
        }

//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();


        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (cur < arr[j]) {
                    arr[j+1] = arr[j];
                    arr[j] = cur;
                } else {
                    break;
                }
            }
        }

//        System.out.println(Arrays.toString(arr));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start); // 500
    }
}
