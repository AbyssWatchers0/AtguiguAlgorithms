package com.abyss.josepfu;

/**
 * 约瑟夫问题：设编号为 1,2,..n 的 n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
 * 数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，以此类推，直到所有人出列为止，
 * 由此产生出一个出队编号的序列
 * @author Abyss Watchers
 * @create 2022-10-14 21:07
 */
public class Client {
    public static void main(String[] args) {
        CircleList circleList = new CircleList();
        circleList.add(new Boy(1));
        circleList.add(new Boy(2));
        circleList.add(new Boy(3));
        circleList.add(new Boy(4));
        circleList.add(new Boy(5));

//        circleList.show();
        circleList.doJosepfu(3);
    }
}
