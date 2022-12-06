package com.abyss.josepfu;

/**
 * @author Abyss Watchers
 * @create 2022-10-14 21:07
 */
public class CircleList {
    private Boy first;
    private Boy last;

    public void add(Boy boy) {
        if (first == null) {
            first = boy;
            last = boy;
        }
        last.setNext(boy);
        last = boy;
        boy.setNext(first);
    }

    public void doJosepfu(int sep) {
        Boy cur = last;
        while (cur.getNext() != cur) {
            for (int i = 0; i < sep - 1; i++) {
                cur = cur.getNext();
            }
            System.out.println(cur.getNext());
            cur.setNext(cur.getNext().getNext());
        }
        System.out.println(cur);
        first = last = null;
    }

    public void show() {
        Boy cur = first;
        do {
            System.out.println(cur);
            cur = cur.getNext();
        } while (cur != first);
    }
}
