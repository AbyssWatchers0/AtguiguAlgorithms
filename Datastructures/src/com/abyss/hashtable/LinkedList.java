package com.abyss.hashtable;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Abyss Watchers
 * @create 2022-10-30 18:48
 */
public class LinkedList<K,V> {
    private Entry<K,V> head;

    /**
     * 添加
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        Entry<K,V> entry = new Entry<K,V>(key, value);
        if (head == null) {
            head = entry;
        } else {
            if (!updateIfExist(entry)) {
                // 头插法
                entry.next = head.next;
                head.next = entry;
            }
        }
    }

    /**
     * 获取
     */
    public V get(K key) {
        Entry<K,V> temp = head;
        int h = key.hashCode();
        while (temp != null) {
            if (temp.hash == h) {
                if (temp.key.equals(key)) {
                    return temp.value;
                }
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 遍历
     */
    public void list() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Entry<K,V> temp = head;
        while (temp != null) {
            System.out.println("{" + temp.key + ":" + temp.value + "}");
            temp = temp.next;
        }
    }

    /**
     * 如果键相同，就更新
     * @param entry
     * @return
     */
    private boolean updateIfExist(Entry<K, V> entry) {
        Entry<K,V> temp = head;
        while (temp != null) {
            if (entry.hash == temp.hash) {
                if (entry.key.equals(temp.key)) {
                    temp.value = entry.value;
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }

    private static class Entry<K,V>{
        private Entry<K,V> next;
        private V value;
        private K key;
        private int hash;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
        }

        public Entry(V value, K key, int hash) {
            this.value = value;
            this.key = key;
            this.hash = hash;
            this.hash = key.hashCode();
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public Entry<K,V> getNext() {
            return next;
        }

        public void setNext(Entry<K,V> next) {
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "value=" + value +
                    ", key=" + key +
                    ", hash=" + hash +
                    '}';
        }
    }
}
