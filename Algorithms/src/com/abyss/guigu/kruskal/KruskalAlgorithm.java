package com.abyss.guigu.kruskal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Abyss Watchers
 * @create 2023-01-01 19:33
 */
public class KruskalAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[][]{
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0},
        };
        graph.init(data, matrix);
        graph.show();


        kruskal(graph);
    }

    public static void kruskal(Graph graph) {
        // 记录了各个顶点对应的终点是哪个
        int[] ends = new int[graph.edgeNum];
        // 记录结果
        List<EdgeData> result = new ArrayList<>();

        // 按边的权值从小到大排序
        sortEdges(graph.edges, graph.edgeNum);
        // System.out.println(Arrays.toString(graph.edges));

        // 遍历edges数组，判断加入的边是否形成回路，如果没有就加入结果集，否则不加入
        for (int i = 0; i < graph.edgeNum; i++) {
            EdgeData edge = graph.edges[i];
            int end1 = getEnd(ends, getEdgeIndexByName(edge.getStart(), graph.data));
            int end2 = getEnd(ends, getEdgeIndexByName(edge.getEnd(), graph.data));
            if (end1 != end2) {
                result.add(edge);
                ends[end1] = end2;
            }
        }

        for (EdgeData edge : result) {
            System.out.println(edge);
        }
    }

    /**
     * 按边的权值从小到大排序
     *
     * @param edges
     * @param edgeNum 边的个数
     */
    public static void sortEdges(EdgeData[] edges, int edgeNum) {
        for (int i = 0; i < edgeNum - 1; i++) {
            for (int j = 0; j < edgeNum - i - 1; j++) {
                if (edges[j].getWeight() > edges[j + 1].getWeight()) {
                    EdgeData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 根据顶点名称获取顶点的下标
     *
     * @param edgeName 顶点名
     * @param edgeData 顶点集合
     * @return 对应的顶点下标
     */
    public static int getEdgeIndexByName(char edgeName, char[] edgeData) {
        for (int i = 0; i < edgeData.length; i++) {
            if (edgeData[i] == edgeName) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取下标为edgeIndex的顶点的终点
     *
     * @param ends      记录了各个顶点对应的终点是哪个
     * @param edgeIndex
     * @return
     */
    public static int getEnd(int[] ends, int edgeIndex) {
        while (ends[edgeIndex] != 0) {
            edgeIndex = ends[edgeIndex];
        }
        return edgeIndex;
    }
}
