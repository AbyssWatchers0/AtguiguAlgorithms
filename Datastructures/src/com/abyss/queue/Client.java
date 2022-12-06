package com.abyss.queue;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-10-12 20:22
 */
public class Client {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.pop();
        for (int i = 1; i < 7; i++) {
            queue.add(i);
        }
        System.out.println(Arrays.toString(queue.getArr()));
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pop());
        }
    }
}
