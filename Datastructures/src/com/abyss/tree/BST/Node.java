package com.abyss.tree.BST;

/**
 * @author Abyss Watchers
 * @create 2022-12-07 20:51
 */
public class Node {
    private int value;
    private Node left;
    private Node right;


    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.getValue() < this.value) {
            if (this.getLeft() == null) {
                setLeft(node);
            } else {
                left.add(node);
            }
        } else if (node.getValue() >= this.value) {
            if (this.getRight() == null) {
                setRight(node);
            } else {
                right.add(node);
            }
        }
    }

    public void infixOrder() {
        if (left != null) {
            left.infixOrder();
        }
        System.out.println(this);
        if (right != null) {
            right.infixOrder();
        }
    }

    public Node find(Node node) {
        Node result = null;
        if (this.isSelected(node)) {
            result = this;
        } else if (hasLeft() && getValue() > node.getValue()) {
            result = getLeft().find(node);
        } else if (hasRight() && getValue() <= node.getValue()) {
            result = getRight().find(node);
        }
        return result;
    }

    public Node findParent(Node node) {
        Node result = null;
        if (this.isSelectedParent(node)) {
            return this;
        }
        if (hasLeft() && getValue() > node.getValue()) {
            result = getLeft().findParent(node);
            if (result != null) {
                return result;
            }
        }
        if (hasRight() && getValue() <= node.getValue()) {
            result = getRight().findParent(node);
            if (result != null) {
                return result;
            }
        }
        return result;
    }

    public boolean isParent() {
        return left != null || right != null;
    }

    public boolean hasOnlyOneChild() {
        return (left != null && right == null) || (left == null && right!= null);
    }

    /**
     * 如果这个节点是只有一个子节点的子树，返回子节点是左子节点还是右子结点
     * @return  true:左  false:右
     */
    public boolean getOnlyOneChildType() {
        if (hasOnlyOneChild()) {
            if (left != null) {
                return true;
            } else {
                return false;
            }
        }
        throw new RuntimeException("只有一个子节点的子树才能调用此方法");
    }

    public boolean isSelected(Node node) {
        return node.getValue() == value;
    }

    public boolean isSelectedParent(Node node) {
        boolean flag = false;
        if (getLeft() != null && getLeft().getValue() == node.getValue()) {
            flag = true;
        } else if (getRight() != null && getRight().getValue() == node.getValue()) {
            flag = true;
        }
        return flag;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
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
}
