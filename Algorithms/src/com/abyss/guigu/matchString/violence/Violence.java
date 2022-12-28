package com.abyss.guigu.matchString.violence;

/**
 * @author Abyss Watchers
 * @create 2022-12-28 20:11
 */
public class Violence {
    public static void main(String[] args) {
        String s1 = "acndbsafdas";
        String s2 = "as";
        int i = violenceMatch(s1, s2);
        System.out.println(i);
    }

    public static int violenceMatch(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int s1len = c1.length;
        int s2len = c2.length;

        int i = 0;
        int j = 0;

        while (s1len - i >= s2len) {
            for (int k = 0; k < s2len; k++) {
                if (c1[i] == c2[j]) {
                    i++;
                    j++;
                } else {
                    i = i - (j - 1);
                    j = 0;
                    break;
                }
            }
            if (j == s2len) {
                return i - j;
            }
        }

        return -1;

    }
}
