package com.abyss.guigu.sort.bubblesort;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-21 20:38
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100000);
        }
//        System.out.println(Arrays.toString(arr));

        boolean flag = true;

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        long stop = System.currentTimeMillis();

        System.out.println(stop - start); // 1500

//        System.out.println(Arrays.toString(arr));
    }
}
