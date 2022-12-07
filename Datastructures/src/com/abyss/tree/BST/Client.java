package com.abyss.tree.BST;

/**
 * @author Abyss Watchers
 * @create 2022-12-07 21:00
 */
public class Client {
    public static void main(String[] args) {
        BinarySortTree bst = new BinarySortTree();
        bst.add(new Node(7));
        bst.add(new Node(4));
        bst.add(new Node(3));
        bst.add(new Node(6));
        bst.add(new Node(5));
        bst.add(new Node(9));

        bst.delete(new Node(6));

        bst.infixOrderTraverse();
    }
}
