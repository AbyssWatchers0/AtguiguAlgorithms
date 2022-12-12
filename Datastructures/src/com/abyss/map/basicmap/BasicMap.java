package com.abyss.map.basicmap;

import sun.security.provider.certpath.Vertex;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Abyss Watchers
 * @create 2022-12-12 21:10
 */
public class BasicMap {
    private ArrayList<Vertex> vertexList;
    private int[][] edges;
    private int edgeNum;

    public BasicMap(int vertexNum) {
        vertexList = new ArrayList<>(vertexNum);
        edges = new int[vertexNum][vertexNum];
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

    class Vertex{
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
