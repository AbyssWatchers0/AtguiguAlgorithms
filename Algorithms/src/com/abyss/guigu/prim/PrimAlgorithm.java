package com.abyss.guigu.prim;

/**
 * @author Abyss Watchers
 * @create 2022-12-30 19:48
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        // 10000 表示不连通
        int[][] matrix = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};
        graph.init(data, matrix);

        MinTree minTree = new MinTree(graph);
        minTree.prim(0);
    }
}
