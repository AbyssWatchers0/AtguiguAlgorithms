package com.abyss.leetcode.array.nextpermutation;

import java.util.Arrays;

/**
 * 下一个排列
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 *
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 *
 * 题解：
 * 以排列 [4,5,2,6,3,1] 为例：
 *
 * 我们能找到的符合条件的一对「较小数」与「较大数」的组合为 2 与 3，满足「较小数」尽量靠右，而「较大数」尽可能小。
 *
 * 当我们完成交换后排列变为 [4,5,3,6,2,1]，此时我们可以重排「较小数」右边的序列，序列变为 [4,5,3,1,2,6]。
 *
 * 具体地，我们这样描述该算法，对于长度为 n 的排列 a：
 *
 * 首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i]<a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
 *
 * 如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i]<a[j]。这样「较大数」即为 a[j]。
 *
 * 交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。
 *
 * @author Abyss Watchers
 * @create 2022-12-10 20:52
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,6,3,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        // 最后一个下标
        int lastIndex = nums.length - 1;
        if (lastIndex < 1) {
            return;
        }
        // 较小数下标
        int lesserNumIndex = -1;
        // 较大数下标
        int largerNumIndex = 0;
        // 找较小数
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                lesserNumIndex = i;
                break;
            }
        }
        // 如果整个数组是降序的话，此时较小数下标为-1，直接反转
        if (lesserNumIndex == -1) {
            reverse(0, lastIndex, nums);
            return;
        }
        // 找较大数
        for (int i = lastIndex; i > lesserNumIndex; i--) {
            if (nums[i] > nums[lesserNumIndex]) {
                largerNumIndex = i;
                break;
            }
        }

        // 交换较大数和较小数
        int temp = nums[lesserNumIndex];
        nums[lesserNumIndex] = nums[largerNumIndex];
        nums[largerNumIndex] = temp;

        // 此时可以保证 较小数下标+1 到 数组最后一个元素的下标 之间的数时降序的，把这个区间内的数反转
        reverse(lesserNumIndex+1, lastIndex, nums);
    }

    public static void reverse(int startIndex, int stopIndex, int[] nums) {
        while (startIndex < stopIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[stopIndex];
            nums[stopIndex] = temp;
            startIndex++;
            stopIndex--;
        }
    }
}
