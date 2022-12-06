package com.abyss.leetcode.huiwenshu;



import java.util.Scanner;

/**
 * 判断是否是回文数
 *
 * @author Abyss Watchers
 * @create 2022-10-12 21:19
 */
public class HuiWenShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

//        System.out.println(isHuiWen1(num)); // 8ms
//        System.out.println(isHuiWen2(num)); // 5ms

//        boolean ish = new StringBuilder(String.valueOf(num)).reverse().toString().equals(String.valueOf(num)); // 10ms
//        System.out.println(ish);
    }

    public static Boolean isHuiWen1(int x) {
        String target = String.valueOf(x);
        Boolean isHuiWen = true;
        int len = target.length();
        for (int i = 0; i < len / 2; i++) {
            if (!target.substring(i, i+1).equals(target.substring(len-i-1, len - i))) {
                isHuiWen = false;
                break;
            }
        }
        return isHuiWen;
    }

    public static boolean isHuiWen2(int x) {
        if (x < 0) {
            return false;
        }
        if (x != 0 && x % 10 == 0) {
            return false;
        }
        int reversedNum = 0;
        while (x > reversedNum) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }
        return x == reversedNum || x == reversedNum / 10;
    }
}
