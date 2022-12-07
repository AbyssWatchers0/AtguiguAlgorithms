package com.abyss.tree.BST;

/**
 * @author Abyss Watchers
 * @create 2022-12-07 20:53
 */
public class BinarySortTree {
    private Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    public void infixOrderTraverse() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        root.infixOrder();
    }

    public void delete(Node node) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        // 要删除的是根节点
        if (root.getValue() == node.getValue()) {
            if (!root.getLeft().isParent()) {
                root.getLeft().setRight(root.getRight());
                root = root.getLeft();
                return;
            }
            if (!root.getRight().isParent()) {
                root.getRight().setLeft(root.getLeft());
                root = root.getLeft();
                return;
            }
            if (root.getLeft() != null) {
                Node tempParent = root;
                Node temp = root.getLeft();
                while (temp.getRight() != null) {
                    tempParent = temp;
                    temp = temp.getRight();
                }
                tempParent.setRight(null);
                temp.setLeft(root.getLeft());
                temp.setRight(root.getRight());
                root = temp;
            } else if (root.getRight() != null) {
                Node tempParent = root;
                Node temp = root.getRight();
                while (temp.getLeft() != null) {
                    tempParent = temp;
                    temp = temp.getLeft();
                }
                tempParent.setLeft(null);
                temp.setLeft(root.getLeft());
                temp.setRight(root.getRight());
                root = temp;
            }
        }
        Node target = root.find(node);
        Node parent = root.findParent(node);

        if (!target.isParent()) {
            // 要删除的是叶子节点
            if (target.getValue() < parent.getValue()) {
                parent.setLeft(null);
            } else if (target.getValue() >= parent.getValue()) {
                parent.setRight(null);
            }
        } else if (target.hasOnlyOneChild()) {
            // 要删除的是只有一个子节点的子树
            if (target.getValue() < parent.getValue()) {
                if (target.getOnlyOneChildType()) {
                    parent.setLeft(target.getLeft());
                } else {
                    parent.setLeft(target.getRight());
                }
            } else if (target.getValue() >= parent.getValue()) {
                if (target.getOnlyOneChildType()) {
                    parent.setRight(target.getLeft());
                } else {
                    parent.setRight(target.getRight());
                }
            }
        } else if (target.isParent()) {
            // 要删除的是有两个子节点的子树
            if (target.getValue() < parent.getValue()) {
                if (target.getLeft() != null) {
                    Node tempParent = null;
                    Node temp = target.getLeft();
                    while (temp.getRight() != null) {
                        tempParent = temp;
                        temp = temp.getRight();
                    }
                    temp.setRight(target.getRight());
                    if (tempParent != null) {
                        temp.setLeft(target.getLeft());
                        tempParent.setRight(null);
                    }
                    parent.setLeft(target.getLeft());
                } else if (target.getRight() != null) {
                    Node tempParent = null;
                    Node temp = target.getRight();
                    while (temp.getLeft() != null) {
                        tempParent = temp;
                        temp = temp.getLeft();
                    }
                    temp.setLeft(target.getLeft());
                    if (tempParent != null) {
                        temp.setRight(target.getRight());
                        tempParent.setLeft(null);
                    }
                    parent.setLeft(target.getRight());
                }
            } else if (target.getValue() >= parent.getValue()) {
                if (target.getLeft() != null) {
                    Node tempParent = null;
                    Node temp = target.getLeft();
                    while (temp.getRight() != null) {
                        tempParent = temp;
                        temp = temp.getRight();
                    }
                    temp.setRight(target.getRight());
                    if (tempParent != null) {
                        temp.setLeft(target.getLeft());
                        tempParent.setRight(null);
                    }
                    parent.setRight(target.getLeft());
                } else if (target.getRight() != null) {
                    Node tempParent = null;
                    Node temp = target.getRight();
                    while (temp.getLeft() != null) {
                        tempParent = temp;
                        temp = temp.getLeft();
                    }
                    temp.setLeft(target.getLeft());
                    if (tempParent != null) {
                        temp.setRight(target.getRight());
                        tempParent.setLeft(null);
                    }
                    parent.setRight(target.getRight());
                }
            }

        }

    }

}
