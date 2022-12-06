package com.abyss.guigu.sort.heapsort;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-11-13 19:33
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100000);
        }
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();

        heapSort(arr);

//        System.out.println(Arrays.toString(arr));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start); // 8
    }

    public static void heapSort(int[] arr) {
        for (int i = (arr.length-2)/2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 把以i为根节点的子树调整为大顶堆
     * @param arr   需要调整的数组
     * @param i     子树的根节点
     * @param length    调整时能比较的范围
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = i * 2 + 1) {
            if (j + 1 < length && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }
}
