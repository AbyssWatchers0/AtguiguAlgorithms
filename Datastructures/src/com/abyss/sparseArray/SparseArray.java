package com.abyss.sparseArray;

import java.io.*;
import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-11 21:19
 */
public class SparseArray {
    public static void main(String[] args) {
        int maxRow = 11;
        int maxCol = 11;
        // 创建初始二维数组 1：黑子 2：白子
        int[][] chessArr = new int[maxRow][maxCol];

        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        System.out.println("初始化棋盘");
        for (int[] chess : chessArr) {
            System.out.println(Arrays.toString(chess));
        }

        // 遍历棋盘 获取非零数据的个数
        int sum = 0;
        for (int[] chess : chessArr) {
            for (int i : chess) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        // 创建稀疏数组 行数为1+非零数据个数 列为3
        int[][] sparseArr = new int[sum+1][3];
        // 填充第一行数据 [几行，几列，几个数据]
        sparseArr[0][0] = maxRow;
        sparseArr[0][1] = maxCol;
        sparseArr[0][2] = sum;

        int sparseRowIndex = 1;
        // 遍历棋盘，把棋子位置信息存入稀疏数组 [行，列，值]
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArr[sparseRowIndex][0] = i;
                    sparseArr[sparseRowIndex][1] = j;
                    sparseArr[sparseRowIndex][2] = chessArr[i][j];
                    sparseRowIndex++;
                }
            }
        }

        System.out.println("生成的稀疏数组");
        for (int[] sparseRow:sparseArr) {
            System.out.println(Arrays.toString(sparseRow));
        }

        // 将稀疏数组保存到磁盘
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("chess.dat"));
            oos.writeObject(sparseArr);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 将磁盘中的稀疏数组读入
        ObjectInputStream ois = null;
        int[][] backupSparseArr = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("chess.dat"));
            backupSparseArr = (int[][]) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("磁盘中读取的稀疏数组");
        for (int[] sparseRow:backupSparseArr) {
            System.out.println(Arrays.toString(sparseRow));
        }

        // 根据稀疏数组 恢复棋盘
        int[][] backupChess = new int[backupSparseArr[0][1]][backupSparseArr[0][1]];
        for (int i = 0; i < backupSparseArr[0][2]; i++) {
            backupChess[backupSparseArr[i+1][0]][backupSparseArr[i+1][1]] = backupSparseArr[i+1][2];
        }

        System.out.println("恢复的棋盘");
        for (int[] chess : backupChess) {
            System.out.println(Arrays.toString(chess));
        }
    }
}
