package com.abyss.guigu.dynamicProgramming;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-12-21 20:42
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        // 物品重量
        int[] w = new int[]{1, 4, 3};
        // 物品价值
        int[] v = new int[]{1500, 3000, 2000};
        // 背包容量
        int contain = 4;
        // 物品种类数
        int typeCount = v.length;

        // 规划表，programme[i][j]:前i个物品中能够装入重量为j的背包的最大价值
        int[][] programme = new int[typeCount + 1][contain + 1];

        for (int i = 1; i <= typeCount; i++) {
            for (int j = 1; j <= contain; j++) {
                if (w[i - 1] > j) {
                    programme[i][j] = programme[i - 1][j];
                } else {
                    programme[i][j] = Math.max(programme[i - 1][j], v[i - 1] + programme[i - 1][j - w[i - 1]]);
                }
            }
        }

        for (int[] pro : programme) {
            System.out.println(Arrays.toString(pro));
        }
    }
}
