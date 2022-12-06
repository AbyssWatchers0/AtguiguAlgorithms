package com.abyss.leetcode.threesumclosest;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-31 20:58
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] arr = {1,1,1,0};
        int i = threeSumClosest.threeSumClosest(arr, 1);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        mergeSort(nums, 0, nums.length - 1);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    if (Math.abs(target - sum) < Math.abs(target - res)) {
                        res = sum;
                    }
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    l++;
                } else {
                    if (Math.abs(target - sum) < Math.abs(target - res)) {
                        res = sum;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                }
            }
        }
        return res;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int i = 0;
        int[] temp = new int[right - left + 1];

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[i] = arr[l];
                l++;
                i++;
            } else {
                temp[i] = arr[r];
                r++;
                i++;
            }
        }

        while (l <= mid) {
            temp[i] = arr[l];
            l++;
            i++;
        }
        while (r <= right) {
            temp[i] = arr[r];
            r++;
            i++;
        }

        i = 0;
        for (int j = left; j <= right; j++) {
            arr[j] = temp[i];
            i++;
        }
    }
}
