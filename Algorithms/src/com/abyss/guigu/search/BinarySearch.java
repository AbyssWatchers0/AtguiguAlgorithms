package com.abyss.guigu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Abyss Watchers
 * @create 2022-10-27 20:08
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 4, 9, 7,3,2,3,1};
        shellSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        List<Integer> res = binarySearch(arr, 2);
        System.out.println(res);
    }

    public static List<Integer> binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;

        ArrayList<Integer> res = new ArrayList<>();

        while(l <= r) {
            mid = (l + r) / 2;
            if (arr[mid] == target) {
                res.add(mid);
                int lef = mid - 1;
                while (arr[lef] == target) {
                    res.add(lef);
                    lef--;
                }
                int rig = mid + 1;
                while (arr[rig] == target) {
                    res.add(rig);
                    rig++;
                }
                return res;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            }
        }

        return res;
    }

    public static void shellSort(int[] arr) {
        for (int group = arr.length / 2; group >= 1; group /= 2) {
            for (int i = group; i < arr.length; i++) {
                int val = arr[i];
                int index = i;
                for (int j = i - group; j >= 0; j -= group) {
                    if (arr[j] > val) {
                        arr[j + group] = arr[j];
                        index -= group;
                    } else {
                        break;
                    }
                }
                arr[index] = val;
            }
        }
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
            if (l == r) {
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
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start+end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr,mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] tempArr = new int[end - start + 1];
        int l = start;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= end) {
            if (arr[l] <= arr[r]) {
                tempArr[index] = arr[l];
                l++;
                index++;
            } else {
                tempArr[index] = arr[r];
                r++;
                index++;
            }
        }
        while (l <= mid) {
            tempArr[index] = arr[l];
            l++;
            index++;
        }
        while (r <= end) {
            tempArr[index] = arr[r];
            r++;
            index++;
        }

        index = 0;
        for (int i = start; i <= end; i++, index++) {
            arr[i] = tempArr[index];
        }
    }
}
