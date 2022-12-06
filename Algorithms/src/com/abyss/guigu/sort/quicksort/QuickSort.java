package com.abyss.guigu.sort.quicksort;

/**
 * @author Abyss Watchers
 * @create 2022-10-24 19:37
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100000);
        }
//        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();

        quickSort(arr, 0, arr.length - 1);

//        System.out.println(Arrays.toString(arr));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start); // 20
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int midVal = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < midVal) {
                l++;
            }
            while (arr[r] > midVal) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == midVal) {
                r--;
            }
            if (arr[r] == midVal) {
                l++;
            }
        }

        if (l == r) {
            r--;
            l++;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
