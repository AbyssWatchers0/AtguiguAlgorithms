package com.abyss.tree.binatree;

/**
 * @author Abyss Watchers
 * @create 2022-10-31 20:21
 */
public class TreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(new HeroNode(3,"松江"));
        tree.add(new HeroNode(1,"鲁智深"));
        tree.add(new HeroNode(2,"武松"));
        tree.add(new HeroNode(4,"吴用"));

        // 遍历
//        tree.travers(TraversType.PREFIX);
//        tree.travers(TraversType.INFIX);
//        tree.travers(TraversType.SUFFIX);

        // 查询
//        System.out.println(tree.get(3));
//        System.out.println(tree.get(TraversType.INFIX, 3));
//        System.out.println(tree.get(TraversType.SUFFIX, 3));

        // 删除
        System.out.println("del:" + tree.del(2));
        System.out.println("del:" + tree.del(3));
        tree.travers();
    }


}
