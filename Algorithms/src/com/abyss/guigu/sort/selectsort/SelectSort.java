package com.abyss.guigu.sort.selectsort;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-22 20:11
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100000);
        }

//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            int minNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minNum) {
                    min = j;
                    minNum = arr[j];
                }
            }
            if (min != i) {
                arr[min] = arr[i];
                arr[i] = minNum;
            }

        }

//        System.out.println(Arrays.toString(arr));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start); // 1580
    }
}
