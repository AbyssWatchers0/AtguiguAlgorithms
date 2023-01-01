package com.abyss.guigu.kruskal;

import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-12-30 19:49
 */
public class Graph {
    int vertexNum; // 顶点个数
    char[] data; // 顶点数据
    int[][] matrix; // 邻接矩阵
    int edgeNum; // 边的个数
    EdgeData[] edges; // 边的信息

    public Graph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.data = new char[vertexNum];
        this.matrix = new int[vertexNum][vertexNum];
    }

    /**
     * 根据传进来的参数初始化图
     * @param data
     * @param matrix
     */
    public void init(char[] data, int[][] matrix) {
        setData(data);
        setMatrix(matrix);
        edges = new EdgeData[vertexNum * (vertexNum - 1)];
        int index = 0;
        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    edgeNum++;
                    edges[index] = new EdgeData(data[i], data[j], matrix[i][j]);
                    index++;
                }
            }
        }

    }

    /**
     * 遍历输出邻接矩阵
     */
    public void show() {
        for (int[] link : matrix) {
            for (int i : link) {
                System.out.printf("%13d", i);
            }
            System.out.println();
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public char[] getData() {
        return data;
    }

    public void setData(char[] data) {
        this.data = data;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
