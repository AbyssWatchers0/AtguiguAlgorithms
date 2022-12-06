package com.abyss.tree.binatree;

/**
 * @author Abyss Watchers
 * @create 2022-10-31 20:31
 */
public enum TraversType {
    /**
     * PREFIX:前序遍历
     * INFIX：中序遍历
     * SUFFIX：后序遍历
     */
    PREFIX(0),
    INFIX(1),
    SUFFIX(2);

    private int type;

    TraversType(int type) {
        this.type = type;
    }


}
