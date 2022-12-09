package com.abyss.tree.avl;

/**
 * @author Abyss Watchers
 * @create 2022-12-07 20:53
 */
public class AVLTree {
    private Node root;

    /**
     * 添加节点
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
//        rotate1();
        myRotate();
    }

    /**
     * 双旋1
     */
    public void rotate1() {
        // 当添加完一个节点后,如果:(右子树高度-左子树的高度)>1,左旋
        // 当添加完一个节点后,如果:(左子树高度-右子树的高度)>1,右旋
        if ((root.rightHeight() - root.leftHeight()) > 1) {
            // 如果右子树的左子树高度大于右子树高度，右子树右旋
            if (root.getRight().leftHeight() > root.getRight().rightHeight()) {
                root.getRight().rightRotate();
            }
            root.leftRotate();
        } else if ((root.leftHeight() - root.rightHeight()) > 1) {
            // 如果左子树的左子树高度小于右子树高度，左子树左旋
            if (root.getLeft().leftHeight() < root.getLeft().rightHeight()) {
                root.getLeft().leftRotate();
            }
            root.rightRotate();
        }
    }

    /**
     * 双旋改
     */
    public void myRotate() {
        // 当添加完一个节点后,如果:(右子树高度-左子树的高度)>1,左旋
        // 当添加完一个节点后,如果:(左子树高度-右子树的高度)>1,右旋
        if ((root.rightHeight() - root.leftHeight()) > 1) {
            // 如果右子树的左子树高度大于右子树高度，右子树右旋
            if (root.getRight().leftHeight() > root.getRight().rightHeight()) {
                Node newRight = root.getRight().myRightRotate();
                root.setRight(newRight);
            }
            root = root.myLeftRotate();
        } else if ((root.leftHeight() - root.rightHeight()) > 1) {
            // 如果左子树的左子树高度小于右子树高度，左子树左旋
            if (root.getLeft().leftHeight() < root.getLeft().rightHeight()) {
                Node newLeft = root.getLeft().myLeftRotate();
                root.setLeft(newLeft);
            }
            root = root.myRightRotate();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrderTraverse() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        root.infixOrder();
    }

    /**
     * 删除节点
     * @param node
     */
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

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
