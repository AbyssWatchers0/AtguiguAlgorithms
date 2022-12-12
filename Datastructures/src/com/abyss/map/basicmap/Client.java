package com.abyss.map.basicmap;


/**
 * @author Abyss Watchers
 * @create 2022-12-12 21:23
 */
public class Client {
    public static void main(String[] args) {
        BasicMap basicMap = new BasicMap(5);
        String[] vertexes = new String[]{"A", "B", "C", "D", "E"};
        for (String vertex : vertexes) {
            basicMap.insertVertex(vertex);
        }

        basicMap.addEdge(0, 2, 1);
        basicMap.addEdge(0, 1, 1);
        basicMap.addEdge(1, 2, 1);
        basicMap.addEdge(1, 3, 1);
        basicMap.addEdge(1, 4, 1);

        basicMap.showMatrix();
    }
}
