package com.abyss.leetcode.countsstudents;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author Abyss Watchers
 * @create 2022-10-19 21:10
 */
public class CountStudents {
    public static void main(String[] args) {
        int[] students = new int[]{1,1,1,0,0,1};
        int[] sandwiches = new int[]{1,0,0,0,1,1};

        int i = countStudents(students, sandwiches);
        System.out.println(i);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;

        for (int s :
                sandwiches) {
            if (s == 0 && s0 > 0) {
                s0--;
            } else if (s == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }

        return s0 + s1;
    }
}
