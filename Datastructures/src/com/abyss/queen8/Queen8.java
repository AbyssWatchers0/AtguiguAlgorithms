package com.abyss.queen8;

/**
 * @author Abyss Watchers
 * @create 2022-10-19 20:44
 */
public class Queen8 {
    private static int count;

    public static void main(String[] args) {
        int[] checkerBoard = new int[8];

        check(checkerBoard, 0);
        System.out.println(count);
    }

    public static void check(int[] checkerBoard, int n) {
        if (n == 8) {
            count++;
            print(checkerBoard);
            return;
        }
        for (int i = 0; i < 8; i++) {
            checkerBoard[n] = i;
            if (judge(checkerBoard, n)) {
                check(checkerBoard, n + 1);
            }
        }
    }

    public static boolean judge(int[] checkerBoard, int n) {
        for (int i = 0; i < n; i++) {
            if (checkerBoard[n] == checkerBoard[i] || Math.abs(n - i) == Math.abs(checkerBoard[n] - checkerBoard[i])) {
                return false;
            }
        }
        return true;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
