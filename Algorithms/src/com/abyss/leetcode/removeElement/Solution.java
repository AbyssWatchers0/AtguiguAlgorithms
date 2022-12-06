package com.abyss.leetcode.removeElement;

/**
 * @author Abyss Watchers
 * @create 2022-11-30 21:07
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,2,0,4,2};
        int len = removeElement(arr, 2);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return right+ 1;
    }
}
