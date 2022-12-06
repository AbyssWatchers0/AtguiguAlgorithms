package com.abyss.linkedlist;

/**
 * @author Abyss Watchers
 * @create 2022-10-12 20:42
 */
public class Client {
    public static void main(String[] args) {
        List list = new List();
        list.add(1, "a");
        list.add(3, "c");
        list.add(4, "d");
        list.add(2, "b");

        list.update(3, "three");

//        list.delete(3);

        list.reverse();

        list.show();
    }
}
