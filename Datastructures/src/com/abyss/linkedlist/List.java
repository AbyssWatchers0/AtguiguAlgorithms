package com.abyss.linkedlist;

/**
 * @author Abyss Watchers
 * @create 2022-10-12 20:36
 */
public class List {
    private HeroNode head = new HeroNode();

    public void add(int no, String name) {
        HeroNode newNode = new HeroNode(no, name, null);
        HeroNode curNode = head;
        while (curNode.getNext() != null) {
            if (curNode.getNext().getNo() > newNode.getNo()) {
                newNode.setNext(curNode.getNext());
                break;
            }
            curNode = curNode.getNext();
        }
        curNode.setNext(newNode);
    }

    public void update(int no, String name) {
        HeroNode curNode = head;
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
            if (curNode.getNo() == no) {
                curNode.setName(name);
                break;
            }
        }
    }

    public void delete(int no) {
        HeroNode curNode = head;
        while (curNode.getNext() != null) {
            if (curNode.getNext().getNo() == no) {
                curNode.setNext(curNode.getNext().getNext());
                break;
            }
            curNode = curNode.getNext();
        }
    }

    public void reverse() {
        HeroNode newHead = new HeroNode();
        HeroNode curHead = head;
        while (head.getNext() != null) {
            curHead = head.getNext();
            head.setNext(curHead.getNext());
            curHead.setNext(newHead.getNext());
            newHead.setNext(curHead);
        }
        head = newHead;
    }

    public void show() {
        HeroNode curNode = head;
        while (curNode.getNext() != null) {
            curNode = curNode.getNext();
            System.out.println(curNode.getNo() + ":" + curNode.getName());
        }
    }
}
