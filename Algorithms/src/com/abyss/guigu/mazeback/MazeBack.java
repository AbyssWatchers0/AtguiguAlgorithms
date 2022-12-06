package com.abyss.guigu.mazeback;

import java.util.Arrays;

/**
 * 迷宫回溯问题
 *
 * @author Abyss Watchers
 * @create 2022-10-18 20:45
 */
public class MazeBack {
    public static void main(String[] args) {
        /**
         * 地图
         * 1：墙  2：通路    3：死路    0：还没走过  7：目的地
         */
        int[][] maze = new int[][]{
                {1,1,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,1,1},
                {1,1,1,1,0,1,1,1,1,1,1},
                {1,1,1,1,0,1,1,1,1,1,1},
                {0,0,0,0,0,1,1,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1,1},
                {1,0,0,0,0,0,0,1,1,1,1},
                {1,1,1,1,0,1,1,1,1,1,1},
                {1,1,0,0,0,0,0,0,0,2,1},
                {1,1,1,1,1,1,1,1,1,1,1}
        };

        setWay(maze, 1,1);

        showMaze(maze);


    }
    public static void showMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] maze, int i, int j) {
        if (maze[8][8] == 2) {
            // 找到目的地
            return true;
        } else {
            if (maze[i][j] == 0) {
                maze[i][j] = 2;
                // 还没走过
                // 分别往 右 下 左 上 探路
                if (setWay(maze, i, j+1)) {
                    return true;
                }else if (setWay(maze, i + 1, j)) {
                    return true;
                }else if (setWay(maze, i, j-1)) {
                    return true;
                }else if (setWay(maze, i - 1, j)) {
                    return true;
                } else {
                    maze[i][j] = 3;
                }
            }
        }
        return false;
    }
}
