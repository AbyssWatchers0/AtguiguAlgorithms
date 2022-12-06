package com.abyss.hashtable;

/**
 * @author Abyss Watchers
 * @create 2022-10-30 19:30
 */
public class HashMap<K, V> {
    private LinkedList<K, V>[] buckets;
    private int size;

    public HashMap() {
        this(8);
    }

    public HashMap(int size) {
        this.size = size;
        buckets = new LinkedList[size];
    }

    public void push(K key, V value) {
        int index = key.hashCode() % size;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        buckets[index].add(key, value);
    }

    public V get(K key) {
        int index = key.hashCode() % size;
        if (buckets[index] == null) {
            return null;
        }
        return buckets[index].get(key);
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            if (buckets[i] != null) {
                System.out.println("=======" + i + "========");
                buckets[i].list();
            }
        }
    }
}
