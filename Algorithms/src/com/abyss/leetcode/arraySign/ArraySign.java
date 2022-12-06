package com.abyss.leetcode.arraySign;

/**
 * @author Abyss Watchers
 * @create 2022-10-27 21:20
 */
public class ArraySign {
    public static void main(String[] args) {
        int[] arr = {-1,-2,-3,-4,3,2,1};
        int res = arraySign(arr);
        System.out.println(res);
    }

    public static int arraySign(int[] nums) {
        int res = 1;
        for (int i : nums) {
            if (i == 0) {
                return 0;
            } else if (i < 0) {
                res *= -1;
            }
        }
        return res;
    }
}
