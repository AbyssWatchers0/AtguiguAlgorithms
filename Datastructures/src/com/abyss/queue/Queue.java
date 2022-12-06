package com.abyss.queue;

/**
 * @author Abyss Watchers
 * @create 2022-10-12 20:10
 */
public class Queue {
    private int maxSize;
    private int rear = 0;
    private int front = 0;
    private int[] arr;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void add(int value) {
        if ((rear + 1) % maxSize == front) {
            System.out.println("队列满");
        } else {
            arr[rear] = value;
            rear = (rear + 1) % maxSize;
        }
    }

    public int pop() {
        int res = -1;
        if (front == rear) {
            System.out.println("队列空");
        } else {
            res = arr[front];
            front = (front + 1) % maxSize;
        }
        return res;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}
