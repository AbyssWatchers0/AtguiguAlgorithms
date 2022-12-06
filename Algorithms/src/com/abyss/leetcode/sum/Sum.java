package com.abyss.leetcode.sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * @author Abyss Watchers
 * @create 2022-10-12 21:06
 */
public class Sum {
    public static void main(String[] args) {
        int [] nums = {2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            if (map.get(target - nums[i]) == null){
                map.put(nums[i], i);
            } else {
                System.out.println(Arrays.toString(new int[] {map.get(target - nums[i]), i}));
                break;
            }
        }
    }
}
