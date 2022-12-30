package com.abyss.guigu.prim;

/**
 * @author Abyss Watchers
 * @create 2022-12-30 20:06
 */
public class MinTree {
    private Graph graph;

    public MinTree(Graph graph) {
        this.graph = graph;
    }

    /**
     * 从图的哪个顶点开始生成最小生成树
     *
     * @param v
     */
    public void prim(int v) {
        int[] visited = new int[graph.vertexNum];
        visited[v] = 1;
        // 记录最小权值
        int minWeight;
        // 记录最小生成树的一条边的两个顶点 v1->v2
        int v1;
        int v2;

        // 要找 顶点数-1 条边
        for (int i = 1; i < graph.vertexNum; i++) {
            minWeight = 10000;
            v1 = -1;
            v2 = -1;

            for (int j = 0; j < graph.vertexNum; j++) {
                // 找到已经访问过的顶点j
                if (visited[j] == 1) {
                    // 找出离这个已访问节点最近的未访问节点
                    for (int k = 0; k < graph.vertexNum; k++) {
                        if (visited[k] == 0 && graph.matrix[j][k] < minWeight) {
                            // 如果 当前节点j 离 未访问节点k 的权值小于最小权值，那么更新最小权值
                            minWeight = graph.matrix[j][k];
                            // 更新最小边的节点
                            v1 = j;
                            v2 = k;
                        }
                    }
                }
            }
            // 此时 v1->v2 为一条最小生成树的边
            System.out.printf("边<%c, %c> 权值：%d\n", graph.getData()[v1], graph.getData()[v2], graph.matrix[v1][v2]);
            // 将 v2 标记为已访问
            visited[v2] = 1;
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
