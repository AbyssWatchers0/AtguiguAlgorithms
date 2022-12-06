package com.abyss.leetcode.shortestsubarray;

/**
 * @author Abyss Watchers
 * @create 2022-10-27 21:25
 */
public class ShortestSubarray {
    public static void main(String[] args) {
        int[] nums = {2,-1,1,2};
        int k = 3;
        int res = shortestSubarray(nums, k);
        System.out.println(res);
    }

    public static int shortestSubarray(int[] nums, int k) {
        int shortestLen = -1;
        int l = 0;
        int r = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

        }
        return 0;
    }
}
