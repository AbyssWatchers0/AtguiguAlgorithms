package com.abyss.map.basicmap;

import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Abyss Watchers
 * @create 2022-12-12 21:10
 */
public class BasicMap {
    private ArrayList<Vertex> vertexList;
    private int[][] edges;
    private int edgeNum;
    private boolean[] isVisited;

    public BasicMap(int vertexNum) {
        vertexList = new ArrayList<>(vertexNum);
        edges = new int[vertexNum][vertexNum];
        isVisited = new boolean[vertexNum];
    }

    /**
     * 获取下一个邻接节点
     *
     * @param cur          当前节点
     * @param lastNeighbor 上一个邻接节点
     * @return 下一个未访问过的邻接节点，如果没有，就返回-1
     */
    private int getNeighbor(int cur, int lastNeighbor) {

        for (int j = lastNeighbor + 1; j < vertexList.size(); j++) {
            if (edges[cur][j] == 1 && !isVisited[j]) {
                return j;
            }
        }

        return -1;
    }

    /**
     * 深度优先遍历
     */
    public void dfs() {
        dfs(0);
        this.isVisited = new boolean[vertexList.size()];
    }
    /**
     * 深度遍历
     *
     * @param v 深度遍历起始节点
     */
    public void dfs(int v) {
        // 输出当前节点并置为已访问
        System.out.println(vertexList.get(v));
        isVisited[v] = true;

        // 获取相邻节点
        int neighbor = getNeighbor(v, -1);

        // 如果有相邻节点
        while (neighbor != -1) {
            if (isVisited[neighbor]) {
                // 如果相邻节点已经被访问，就获取下一个相邻节点
                neighbor = getNeighbor(v, neighbor);
            } else {
                // 如果相邻节点没有被访问过，就深度遍历相邻节点
                dfs(neighbor);
            }
        }
    }

    /**
     * 广度优先
     */
    public void bfs() {
        if (vertexList.size() <= 0) {
            return;
        }
        // 当前节点下标
        int cur = 0;
        // 当前节点的邻接节点下标
        int neighbor;
        // 记录访问节点顺序的队列
        LinkedList<Integer> queue = new LinkedList<>();
        // 访问第一个节点
        System.out.println(vertexList.get(cur));
        // 标记为已访问
        isVisited[cur] = true;
        // 记录到队列
        queue.addLast(cur);

        while (!queue.isEmpty()) {
            // 取出当前队列记录的第一条数据作为当前节点
            cur = queue.removeFirst();
            // 获取当前节点的第一个邻接节点
            neighbor = getNeighbor(cur, -1);
            while (neighbor != -1) {
                if (!isVisited[neighbor]) {
                    // 如果有未访问过的邻接节点
                    // 访问节点
                    System.out.println(vertexList.get(neighbor));
                    // 标记为已访问
                    isVisited[neighbor] = true;
                    // 记录到队列
                    queue.addLast(neighbor);
                }
                // 找下一个邻接节点
                neighbor = getNeighbor(cur, neighbor);
            }
        }

        isVisited = new boolean[vertexList.size()];
    }

    public void insertVertex(String data) {
        vertexList.add(new Vertex(data));
    }

    public void addEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNum++;
    }

    public void showMatrix() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    class Vertex {
        private String value;

        public Vertex() {
        }

        public Vertex(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
