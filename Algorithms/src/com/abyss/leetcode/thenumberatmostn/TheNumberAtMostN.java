package com.abyss.leetcode.thenumberatmostn;


/**
 * 最大数为n的组合
 * 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
 *
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
 *
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 *
 * @author Abyss Watchers
 * @create 2022-10-18 21:54
 */
public class TheNumberAtMostN {
    public static void main(String[] args) {
        String[] strings = {"7"};
        String[] strings1 = {
            "1", "4", "9"
        };
        int n = 8;
        int n1 = 1000000000;
        int i = atMostNGivenDigitSet(strings1, n1);
        System.out.println(i);
    }
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        // 如果digit生成的数的位数 小于 n的位数，有 digit.length ^ 位数 个结果
        // 如果digit生成的数的位数 等于 n的位数，
        //  循环判断digit中的数字是不是都小于n的第j位，
        //      小于：有 digit.length() ^ 剩余位数 个结果
        //      等于：跳过本次循环，判断n的下一位数
        //      大于: 因为digit中的数字不是降序，说明接下来的数字都大于等于n的第j位数，结束

        String num = String.valueOf(n);
        int res = 0;
        for (int i = 1; i < num.length(); i++) {
            res += Math.pow(digits.length, i);
        }

        boolean flag = true;
        for (int i = 0; i < num.length(); i++) {
            // 从左到右获取n的第几位数的值
            int x = num.charAt(i) - '0';
            int temp = (int) Math.pow(digits.length, num.length() - 1 - i);
            int j = 0;
            for (j = 0; j < digits.length; j++) {
                if (digits[j].charAt(0) - '0' < x) {
                    res += temp;
                } else {
                    break;
                }
            }
            if (j < digits.length && digits[j].charAt(0)-'0' == x) {
                continue;
            }
            flag = false;
            break;
        }

        if (flag) {
            res++;
        }

        return res;
    }

}

