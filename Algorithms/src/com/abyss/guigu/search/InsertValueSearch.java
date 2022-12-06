package com.abyss.guigu.search;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-28 20:12
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11,13,15,17,19,21,24,26,28,30};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        int i = insertValueSearch(arr, 13);
        System.out.println(i);
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > val) {
                    arr[j+1] = arr[j];
                    index--;
                } else {
                    break;
                }
            }
            arr[index] = val;
        }
    }
    public static int insertValueSearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;

        while (l <= r) {
            System.out.println("search");
            mid = l + (r - l) * ((target - arr[l])/(Math.max(arr[r], target) - Math.min(arr[l], target)));
            if (target < arr[mid]) {
                r = mid - 1;
            }else if (target > arr[mid]) {
                l = mid + 1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}
