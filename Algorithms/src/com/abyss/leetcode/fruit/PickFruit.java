package com.abyss.leetcode.fruit;

import java.util.*;

/**
 * @author Abyss Watchers
 * @create 2022-10-17 21:17
 */
public class PickFruit {
    public static void main(String[] args) {
        int i = totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
        System.out.println(i);
    }

    public static int totalFruit(int[] fruits) {
        // 下标表示水果类型，值表示是否被选中，1：选中   0：未选中
        int[] selectedFruit = new int[fruits.length];
        // 起始下标
        int startIndex = 0;
        // 水果类型变换的下标
        int diffIndex = 0;
        // 当前有几种水果
        int types = 0;
        // 记录滑动窗口中水果数量的历史最最大值   也就是结果
        int res = 0;
        // 当前水果的类型
        int curType = 0;

        for (int i = 0; i < fruits.length; i++) {
            // 当前类型的水果没被选中
            if (selectedFruit[fruits[i]] == 0) {
                // 判断当前水果的种类是不是2
                if (types == 2) {
                    // 是2的话 表示有新品种的水果了
                    // 让结果等于 当前最大值和当前窗口中的数量 中的最大值
                    res = Math.max(res, i - startIndex);
                    // 把去掉的水果设为未选中
                    selectedFruit[fruits[diffIndex - 1]] = 0;
                    // 把新增的水果设为选中
                    selectedFruit[fruits[i]] = 1;
                    // 把滑动窗口的起始下标置为最近一次发生水果类型变化的下标
                    startIndex = diffIndex;
                    // 最近一次发生水果类型变化的下标 置为 当前水果
                    diffIndex = i;

                } else {
                    // 当前水果种类没到2，就加
                    selectedFruit[fruits[i]] = 1;
                    types++;
                }
            }

            // 上个水果的类型和这次水果的类型不同的话
            if (curType != fruits[i]) {
                // 当前水果类型改变
                curType = fruits[i];
                // 记录水果类型变换时的index
                diffIndex = i;
            }
        }

        return Math.max(res, fruits.length - startIndex);
    }
}
