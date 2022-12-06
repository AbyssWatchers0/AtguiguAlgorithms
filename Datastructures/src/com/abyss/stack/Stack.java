package com.abyss.stack;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-15 20:38
 */
public class Stack {
    int button, top = -1;
    int size;
    int[] arr;

    public Stack() {
    }

    public Stack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int value) {
        top++;
        if (top >= size) {
            arr = Arrays.copyOf(this.arr, size * 2);
        }
        arr[top] = value;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("栈空");
            return;
        }
        System.out.println(top + ":" + arr[top]);
        top--;
    }
}
