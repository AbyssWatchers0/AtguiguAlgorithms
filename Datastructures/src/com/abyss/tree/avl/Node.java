package com.abyss.tree.avl;

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

    /**
     * 返回左子树的高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    /**
     * 返回右子树的高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    /**
     * 返回以当前节点为根节点的树的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左旋1
     */
    public void leftRotate() {
        Node newNode = new Node(value);
        newNode.setLeft(left);
        newNode.setRight(right.left);
        value = right.value;
        left = newNode;
        right = right.right;
    }
    /**
     * 右旋1
     */
    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.setLeft(left.right);
        newNode.setRight(right);
        value = left.value;
        right = newNode;
        left = left.left;
    }

    /**
     * 左旋2
     *
     * @return 左旋后的根节点
     */
    public Node myLeftRotate() {
        // temp 是当前节点的右节点，左旋后是根节点
        Node temp = right;
        right = temp.left;
        temp.left = this;
        return temp;
    }
    /**
     * 右旋2
     *
     * @return 左旋后的根节点
     */
    public Node myRightRotate() {
        // temp 是当前节点的右节点，左旋后是根节点
        Node temp = left;
        left = temp.right;
        temp.right = this;
        return temp;
    }


    /**
     * 加入节点
     *
     * @param node
     */
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

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (left != null) {
            left.infixOrder();
        }
        System.out.println(this);
        if (right != null) {
            right.infixOrder();
        }
    }

    /**
     * 查询节点
     *
     * @param node
     * @return
     */
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

    /**
     * 找到指定节点的父节点
     *
     * @param node
     * @return
     */
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

    /**
     * 判断当前节点是不是父节点
     *
     * @return
     */
    public boolean isParent() {
        return left != null || right != null;
    }

    /**
     * 判断当前节点是不是只有一个子节点
     *
     * @return
     */
    public boolean hasOnlyOneChild() {
        return (left != null && right == null) || (left == null && right != null);
    }

    /**
     * 如果这个节点是只有一个子节点的子树，返回子节点是左子节点还是右子结点
     *
     * @return true:左  false:右
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

    /**
     * 判断当前节点是不是要查询的节点
     *
     * @param node
     * @return
     */
    public boolean isSelected(Node node) {
        return node.getValue() == value;
    }

    /**
     * 判断当前节点是不是要查找节点的父节点
     *
     * @param node
     * @return
     */
    public boolean isSelectedParent(Node node) {
        boolean flag = false;
        if (getLeft() != null && getLeft().getValue() == node.getValue()) {
            flag = true;
        } else if (getRight() != null && getRight().getValue() == node.getValue()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断当前节点有没有左子节点
     *
     * @return
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * 判断当前节点有没有右子结点
     *
     * @return
     */
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
