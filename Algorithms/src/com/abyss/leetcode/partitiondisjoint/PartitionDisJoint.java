package com.abyss.leetcode.partitiondisjoint;

/**
 * @author Abyss Watchers
 * @create 2022-10-24 20:39
 */
public class PartitionDisJoint {
    public static void main(String[] args) {
        int[] arr = {24,11,49,80,63,8,61,22,73,85};
        int i = partitionDisjoint(arr);
        System.out.println(i);
    }
    public static int partitionDisjoint(int[] nums) {
        int count = 1;
        int leftMax = nums[0];
        int maxCatch = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < leftMax) {
                count = i + 1;
                leftMax = maxCatch;
            } else {
                maxCatch = Math.max(maxCatch, nums[i]);
            }
        }
        return count;
    }
}
