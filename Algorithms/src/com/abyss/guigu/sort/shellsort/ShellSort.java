package com.abyss.guigu.sort.shellsort;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-23 20:54
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100000);
        }
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();

        shellSort2(arr);

//        System.out.println(Arrays.toString(arr));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start); // 16
    }

    /**
     * 希尔排序 交换法
     * 16
     *
     * @param arr
     */
    public static void shellSort1(int[] arr) {
        for (int group = arr.length/2; group > 0; group/=2) {
            for (int i = group; i < arr.length; i++) {
                int cur = arr[i];
                for (int j = i - group; j >= 0; j-=group) {
                    if (cur < arr[j]) {
                        arr[j + group] = arr[j];
                        arr[j] = cur;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序 位移式
     * 12
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        for (int group = arr.length/2; group > 0; group/=2) {
            for (int i = group; i < arr.length; i++) {
                int cur = arr[i];
                int j = i - group;
                while (j >= 0 && cur < arr[j]) {
                    arr[j + group] = arr[j];
                    j -= group;
                }

                arr[j + group] = cur;
            }
        }
    }
}
