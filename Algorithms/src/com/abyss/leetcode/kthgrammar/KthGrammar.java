package com.abyss.leetcode.kthgrammar;

/**
 * 第k个语法符号
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 *
 * @author Abyss Watchers
 * @create 2022-10-20 21:38
 */
public class KthGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(1, 1)); // 0
        System.out.println(kthGrammar(2, 1)); // 0
        System.out.println(kthGrammar(2, 2)); // 1
        System.out.println(kthGrammar(3, 4)); // 0
        System.out.println(kthGrammar(5, 12)); // 1
    }
    public static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int halfLen = 1 << (n - 2);
        if (k <= halfLen) {
            return kthGrammar(n - 1, k);
        } else {
            return 1 ^ kthGrammar(n-1,k-halfLen);
        }
    }
}
