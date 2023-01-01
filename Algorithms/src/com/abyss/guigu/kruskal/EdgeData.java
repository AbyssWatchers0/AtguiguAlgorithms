package com.abyss.guigu.kruskal;

/**
 * @author Abyss Watchers
 * @create 2023-01-01 19:53
 */
public class EdgeData {
    private char start;
    private char end;
    private int weight;

    public EdgeData() {
    }

    public EdgeData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EdgeData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }

    public char getStart() {
        return start;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
