package com.abyss.leetcode.possibledichotomies;

/**
 * 可能的二分法
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 * @author Abyss Watchers
 * @create 2022-10-16 21:15
 */
public class PossibleDichotomies {
    public static void main(String[] args) {
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};

        boolean b = possibleBipartition(n, dislikes);
        System.out.println(b);
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        // 创建矩阵，矩阵中的行表示编号，值为1的列表示这个编号的人不喜欢的编号
        int[][] matrix = new int[n + 1][n + 1];
        for (int[] item : dislikes) {
            matrix[item[0]][item[1]] = matrix[item[1]][item[0]] = 1;
        }

        // 创建数组来记录对应编号的分组情况,1:红队  -1:蓝队
        int[] record = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // 如果当前编号没分组，就分组并判断分完组有没有冲突，有冲突返回false
            if (record[i] == 0 && !difs(matrix, record, i, 1, n)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param matrix 不喜欢关系的矩阵
     * @param record 分组记录
     * @param cur 当前编号
     * @param group 1：红队    -1：蓝队
     * @param n 共几人
     * @return false:有冲突    true:没冲突
     */
    public static boolean difs(int[][] matrix, int[] record, int cur,int group, int n) {
        // 给当前编号分组
        record[cur] = group;
        // 遍历当前编号和其他人的关系
        for (int i = 1; i <= n; i++) {
            if (i == cur) {
                // 自己和自己的关系不需要判断
                continue;
            }
            // 找到有冲突的编号，并且 如果这个编号和自己在一组，说明有冲突
            if (matrix[cur][i] == 1 && record[i] == group) {
                return false;
            }
            // 如果这个有冲突的编号还没有分组，并且 如果把它分到另一组有冲突，就说明有冲突
            if (matrix[cur][i] == 1 && record[i] == 0 && !difs(matrix, record, i, group*-1, n)) {
                return false;
            }
        }

        return true;
    }
}
