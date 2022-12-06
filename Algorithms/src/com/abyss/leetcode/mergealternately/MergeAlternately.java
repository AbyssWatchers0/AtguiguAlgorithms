package com.abyss.leetcode.mergealternately;

/**
 * @author Abyss Watchers
 * @create 2022-10-23 21:44
 */
public class MergeAlternately {
    public static void main(String[] args) {
        String s = mergeAlternately("abcd", "pq");
        System.out.println(s);
    }
    public static String mergeAlternately(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int tailLength = Math.abs(c1.length - c2.length);
        String tail = null;
        int i = 0;
        if (c1.length > c2.length) {
            i = c1.length - tailLength;
            tail = word1.substring(word1.length() - tailLength);
        } else {
            i = c2.length - tailLength;
            tail = word2.substring(word2.length() - tailLength);
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(c1[j]).append(c2[j]);
        }

        sb.append(tail);
        return sb.toString();
    }
}
