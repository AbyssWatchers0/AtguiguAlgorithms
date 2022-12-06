package com.abyss.leetcode.shortestbridge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Abyss Watchers
 * @create 2022-10-25 21:28
 */
public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}};
        int i = shortestBridge(grid);
        System.out.println(i);
        for (int k = 0; k < grid.length; k++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[k][j]);
            }
            System.out.println();
        }
    }

    private static Queue<int[]> edges;
    private static int[][] positions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static int shortestBridge(int[][] grid) {
        edges = new LinkedList<>();
        // 寻找第一个岛屿
        flag:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 找到了之后，把岛屿填充为2，并找到岛屿外围的第一圈，存入edges
                    fullIsland(grid, i, j);
                    break flag;
                }
            }
        }

        int res = 0;
        // 一圈圈遍历边缘，知道找到另一个岛屿
        while (!edges.isEmpty()) {
            res++;
            int nums = edges.size();

            // 遍历一圈
            for (int i = 0; i < nums; i++) {
                int[] edge = edges.poll();
                // 往四周看看
                for (int[] p : positions) {
                    int nex = edge[0] + p[0];
                    int ney = edge[1] + p[1];
                    // 如果旁边是陆地，直接结束
                    if (isLegal(grid, nex, ney) && grid[nex][ney] == 1) {
                        return res;
                        // 如果旁边是海，把位置存入边缘下标数组edges
                    } else if (isLegal(grid, nex, ney) && grid[nex][ney] == 0) {
                        edges.offer(new int[]{nex, ney});
                        grid[nex][ney] = 2;
                    }
                }
            }
        }


        return res;
    }

    /**
     * 把岛屿填充为2，并找到岛屿外围的第一圈，存入edges
     *
     * @param grid
     * @param i
     * @param j
     */
    public static void fullIsland(int[][] grid, int i, int j) {
        if (!isLegal(grid, i, j) || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 2;
            edges.offer(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        for (int[] p : positions) {
            fullIsland(grid, i + p[0], j + p[1]);
        }
    }

    /**
     * 判断当前位置是否合法（不越界）
     *
     * @return
     */
    public static boolean isLegal(int[][] grid, int i, int j) {
        return i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[0].length - 1;
    }
}
