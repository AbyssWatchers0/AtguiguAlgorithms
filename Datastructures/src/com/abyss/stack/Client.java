package com.abyss.stack;

/**
 * @author Abyss Watchers
 * @create 2022-10-15 20:45
 */
public class Client {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        for (int i = 0; i < 7; i++) {
            stack.push((i + 1) * 10);
        }
        for (int i = 0; i < 8; i++) {
            stack.pop();
        }
    }
}
