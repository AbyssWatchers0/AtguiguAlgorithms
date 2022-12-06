package com.abyss.tree.threadedbinatree;


/**
 * @author Abyss Watchers
 * @create 2022-10-31 20:21
 */
public class ThreadedTreeTest {
    public static void main(String[] args) {
        ThreadedTree tree = new ThreadedTree();
        tree.add(new HeroNode(3, "松江"));
        tree.add(new HeroNode(1, "鲁智深"));
        tree.add(new HeroNode(2, "武松"));
        tree.add(new HeroNode(4, "吴用"));

        tree.convertToThreadedTree();

        tree.traversThreadedTree();
    }


}
