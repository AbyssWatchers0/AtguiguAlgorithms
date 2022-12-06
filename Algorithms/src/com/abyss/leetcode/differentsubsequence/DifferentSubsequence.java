package com.abyss.leetcode.differentsubsequence;

/**
 * 不同的子序列
 * 给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
 *
 * 字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
 *
 * 例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
 *
 *
 *
 * @author Abyss Watchers
 * @create 2022-10-14 21:56
 */
public class DifferentSubsequence {
    public static void main(String[] args) {
        System.out.println(getSubCount("abc"));
    }

    public static int getSubCount(String s) {
        int mod = (int) (1e9 + 7);
        // 记录总共26个字符新增的个数
        int[] preCount = new int[26];
        // 当前字符序列个数
        int curCount = 1;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 新增的子序列数
            int newCount = curCount;
            // 当前的子序列数 = 当前的子序列数 + 新增的子序列数 - 上次这个字符新增的子序列数
            curCount = ((curCount + newCount) % mod - preCount[chars[i] - 'a'] + mod) % mod;
            // 记录当前字符新增的子序列数
            preCount[chars[i] - 'a'] = newCount;
        }
        // 减去空串
        return curCount - 1;
    }
}
