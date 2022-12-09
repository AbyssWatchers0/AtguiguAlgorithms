package com.abyss.tree.avl;

/**
 * @author Abyss Watchers
 * @create 2022-12-09 20:41
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//        int [] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 8, 7, 9, 6, 12};
//        int[] arr = {10, 11, 5, 4, 6, 7, 8, 9};
        int[] arr = {5, 10, 9, 8, 7, 6};
        AVLTree tree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node(arr[i]));
        }

        tree.infixOrderTraverse();

        System.out.println("树的高度=" + tree.getRoot().height());
        System.out.println("树的左子树的高度=" + tree.getRoot().leftHeight());
        System.out.println("树的右子树高度=" + tree.getRoot().rightHeight());
    }
}
