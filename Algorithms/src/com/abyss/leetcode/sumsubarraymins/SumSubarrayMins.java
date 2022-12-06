package com.abyss.leetcode.sumsubarraymins;

/**
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 *
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *
 * @author Abyss Watchers
 * @create 2022-10-28 20:42
 */
public class SumSubarrayMins {
    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
                int res = sumSubarrayMins(arr);
        System.out.println(res);
    }
    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = (int) (Math.pow(10,9) + 7);
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
                sum = (sum + min)%mod;
            }
        }
        return sum;
    }
}
