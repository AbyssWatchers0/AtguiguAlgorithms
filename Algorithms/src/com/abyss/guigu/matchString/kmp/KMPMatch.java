package com.abyss.guigu.matchString.kmp;

import java.util.Arrays;

/**
 * 部分匹配值是 前缀 和 后缀 的最长共有元素的长度
 * @author Abyss Watchers
 * @create 2022-12-28 20:54
 */
public class KMPMatch {
    public static void main(String[] args) {
        String s1 = "ABDC ABCDEABCDAEDA";
        String s2 = "EDA";
        int i = kmpMatch(s1, s2);
        System.out.println(i);

    }

    public static int kmpMatch(String str1, String str2) {
        // 子串的部分匹配表
        int[] next = kmpNext(str2);
        for (int i = 0, j = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            } else {
                // i - j:起点
                // j - next[j]:偏移量
                // 计算新的起点
                i = i - j + (j - next[j]);
                j = 0;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 获取字符串的部分匹配表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        // 部分匹配值表
        int[] next = new int[dest.length()];
        // 一个字符的部分匹配值都为0
        next[0] = 0;
        // 长度为 i+1 的字符串 的 部分匹配值为j
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
