package com.abyss.guigu.divideAndConquer;

/**
 * @author Abyss Watchers
 * @create 2022-12-20 18:37
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi("A", "B", "C", 3);
    }

    /**
     * a塔 通过b 移动到c
     * @param a
     * @param b
     * @param c
     * @param height
     */
    private static void hanoi(String a, String b, String c, int height) {
        if (height == 1) {
            System.out.println(a + "->" + c);
            return;
        }
        hanoi(a, c, b, height - 1);
        System.out.println(a + "->" + c);
        hanoi(b,a,c,height - 1);
    }
}
