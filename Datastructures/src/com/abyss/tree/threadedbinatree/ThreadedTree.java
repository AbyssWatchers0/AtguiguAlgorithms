package com.abyss.tree.threadedbinatree;

/**
 * @author Abyss Watchers
 * @create 2022-11-11 20:40
 */
public class ThreadedTree {
    private HeroNode root;

    public ThreadedTree() {
    }

    public ThreadedTree(HeroNode root) {
        this.root = root;
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 按no大小添加节点
     *
     * @param node
     */
    public void add(HeroNode node) {
        if (root == null) {
            root = node;
            return;
        }
        HeroNode temp = root;
        while (temp != null) {
            if (node.getNo() <= temp.getNo()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(node);
                    break;
                } else {
                    temp = temp.getLeft();
                }
            } else if (node.getNo() > temp.getNo()) {
                if (temp.getRight() == null) {
                    temp.setRight(node);
                    break;
                } else {
                    temp = temp.getRight();
                }
            }
        }
    }

    /**
     * 线索化二叉树
     */
    public void convertToThreadedTree() {
        threadedNode(root);
    }
    // 线索化二叉树时用到的前一个节点
    private HeroNode pre;
    private void threadedNode(HeroNode node) {
        if (node == null) {
            return;
        }
        // 线索化左子树
        threadedNode(node.getLeft());

        // 线索化当前节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        // 线索化右子树
        threadedNode(node.getRight());
    }

    // 遍历中序线索化二叉树
    public void traversThreadedTree() {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node= node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    /**
     * 指定遍历方式遍历
     *
     * @param type
     */
    public void travers(TraversType type) {
        if (root == null) {
            System.out.println("空树！");
            return;
        }
        switch (type) {
            case PREFIX:
                prefixTravers(root);
                break;
            case INFIX:
                infixTravers(root);
                break;
            case SUFFIX:
                suffixTravers(root);
                break;
            default:
                throw new RuntimeException("no this travers type");
        }
    }
    public void travers() {
        prefixTravers(root);
    }
    /**
     * 前序遍历
     *
     * @param node
     */
    public void prefixTravers(HeroNode node) {
        if (node == null) {
            System.out.println("前序遍历空节点！");
            return;
        }
        System.out.println(node);
        if (node.getLeft() != null) {
            prefixTravers(node.getLeft());
        }
        if (node.getRight() != null) {
            prefixTravers(node.getRight());
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void infixTravers(HeroNode node) {
        if (node == null) {
            System.out.println("中序遍历空节点！");
            return;
        }
        if (node.getLeft() != null) {
            infixTravers(node.getLeft());
        }
        System.out.println(node);
        if (node.getRight() != null) {
            infixTravers(node.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void suffixTravers(HeroNode node) {
        if (node == null) {
            System.out.println("后序遍历空节点！");
            return;
        }
        if (node.getLeft() != null) {
            suffixTravers(node.getLeft());
        }
        if (node.getRight() != null) {
            suffixTravers(node.getRight());
        }
        System.out.println(node);
    }

    /**
     * 默认前序遍历查找
     *
     * @param key
     * @return
     */
    public HeroNode get(int key) {
        return get(TraversType.PREFIX, key);
    }

    /**
     * 指定遍历方式查找
     *
     * @param type
     * @param key
     * @return
     */
    public HeroNode get(TraversType type, int key) {
        if (root == null) {
            System.out.println("空树！");
            return null;
        }
        switch (type) {
            case PREFIX:
                return prefixSearch(root, key);
            case INFIX:
                return infixSearch(root, key);
            case SUFFIX:
                return suffixSearch(root, key);
            default:
                throw new RuntimeException("no this travers type");
        }
    }

    /**
     * 前序遍历查找
     * @param node
     * @param key
     * @return
     */
    public HeroNode prefixSearch(HeroNode node, int key) {
        if (node == null) {
            return null;
        }
        HeroNode res;
        System.out.println("pre:" + node.getNo());
        if (node.getNo() == key) {
            return node;
        }
        if (node.getLeft() != null) {
            res = prefixSearch(node.getLeft(), key);
            if (res != null) {
                return res;
            }
        }
        if (node.getRight() != null) {
            res =  prefixSearch(node.getRight(), key);
            if (res != null) {
                return res;
            }
        }
        return null;
    }
    /**
     * 中序遍历查找
     * @param node
     * @param key
     * @return
     */
    public HeroNode infixSearch(HeroNode node, int key) {
        if (node == null) {
            return null;
        }
        HeroNode res;
        if (node.getLeft() != null) {
            res = infixSearch(node.getLeft(), key);
            if (res != null) {
                return res;
            }
        }
        System.out.println("in:" + node.getNo());
        if (node.getNo() == key) {
            return node;
        }
        if (node.getRight() != null) {
            res =  infixSearch(node.getRight(), key);
            if (res != null) {
                return res;
            }
        }
        return null;
    }
    /**
     * 后序遍历查找
     * @param node
     * @param key
     * @return
     */
    public HeroNode suffixSearch(HeroNode node, int key) {
        if (node == null) {
            return null;
        }
        HeroNode res;
        if (node.getLeft() != null) {
            res = suffixSearch(node.getLeft(), key);
            if (res != null) {
                return res;
            }
        }
        if (node.getRight() != null) {
            res =  suffixSearch(node.getRight(), key);
            if (res != null) {
                return res;
            }
        }
        System.out.println("suf:" + node.getNo());
        if (node.getNo() == key) {
            return node;
        }
        return null;
    }


    /**
     * 删除节点
     * @param key
     * @return
     */
    public HeroNode del(int key) {
        if (root == null) {
            System.out.println("空树！");
            return null;
        } else if (root.getNo() == key) {
            HeroNode res = root;
            root = null;
            return res;
        }
        return del(root, key);
    }
    public HeroNode del(HeroNode node, int key) {
        HeroNode res = null;
        if (node.getLeft() != null && node.getLeft().getNo() == key) {
            res = node.getLeft();
            node.setLeft(null);
        } else if (node.getLeft() != null) {
            res = del(node.getLeft(), key);
        }
        if (res != null) {
            return res;
        }
        if (node.getRight() != null && node.getRight().getNo() == key) {
            res = node.getRight();
            node.setRight(null);
        } else if (node.getRight() != null) {
            res = del(node.getRight(), key);
        }
        return res;
    }
}
