package com.abyss.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Abyss Watchers
 * @create 2022-11-30 20:38
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] nums = {13, 7, 8, 3, 29, 6, 1};
        Node node = toHuffman(nums);
        prefixTraverse(node);
    }

    public static Node toHuffman(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            int val = nodes.get(0).getValue() + nodes.get(1).getValue();
            Node node = new Node(val, nodes.get(0), nodes.get(1));
            nodes.remove(1);
            nodes.remove(0);
            nodes.add(node);
        }
        return nodes.get(0);
    }
    public static void prefixTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getValue());
        if (node.getLeft() != null) {
            prefixTraverse(node.getLeft());
        }
        if (node.getRight() != null) {
            prefixTraverse(node.getRight());
        }
    }
}

class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.getValue();
    }
}
