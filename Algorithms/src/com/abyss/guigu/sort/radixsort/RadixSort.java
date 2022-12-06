package com.abyss.guigu.sort.radixsort;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-26 21:16
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 10000000);
        }

//        System.out.println(Arrays.toString(arr));

        long start = System.currentTimeMillis();

        radixSort(arr);

        long stop = System.currentTimeMillis();
        System.out.println(stop - start); // 10 - 20

//        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // 10个桶
        int[][] bucket = new int[10][arr.length];
        // 存放每个桶的元素个数
        int[] bucketElement = new int[bucket.length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int len = (max + "").length();

        int digit = 1;
//        boolean flag = true;
        for (int k = 0; k < len; k++) {
            for (int i = 0; i < arr.length; i++) {
                // 获取 个十百千万... 位的值
                int num = (int) (arr[i] / digit % 10);
                bucket[num][bucketElement[num]] = arr[i];
                bucketElement[num]++;
            }
//            if (bucketElement[0] == arr.length) {
//                flag = false;
//            }
            int index = 0;
            // 把桶里是数据存入数组arr
            for (int i = 0; i < bucket.length; i++) {
                if (bucketElement[i] != 0) {
                    for (int j = 0; j < bucketElement[i]; j++) {
                        arr[index] = bucket[i][j];
                        index++;
                    }
                    bucketElement[i] = 0;
                }
            }
            digit *= 10;
        }
    }
}
