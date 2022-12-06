package com.abyss.guigu.sort.mergesort;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-25 20:34
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100000);
        }
        int[] temp = new int[arr.length];
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();

        mergeSort(arr, 0, arr.length - 1, temp);

//        System.out.println(Arrays.toString(arr));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start); // 9
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左边数组起始下标
        int l = left;
        // 右边数组起始下标
        int r = mid + 1;
        // temp的起始指针
        int t = 0;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }

        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }

        t = 0;
        // 合并
        while (left <= right) {
            arr[left] = temp[t];
            t++;
            left++;
        }

    }
}
