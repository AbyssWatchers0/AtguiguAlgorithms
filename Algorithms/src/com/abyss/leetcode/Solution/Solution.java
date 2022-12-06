package com.abyss.leetcode.Solution;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-11-13 20:03
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,3,4,4};
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int p = 0;
        for (int q = 0; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
        }
        return p + 1;
    }
}
