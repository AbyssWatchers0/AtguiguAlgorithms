package com.abyss.josepfu;

/**
 * @author Abyss Watchers
 * @create 2022-10-14 21:07
 */
public class Boy {
    private int id;
    private Boy next;

    public Boy() {
    }

    public Boy(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
