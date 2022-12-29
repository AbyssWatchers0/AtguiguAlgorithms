package com.abyss.guigu.greedy;

import java.util.*;

/**
 * @author Abyss Watchers
 * @create 2022-12-29 19:56
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        String[] strings = {"北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连"};
        List<String> cities = new ArrayList<>(Arrays.asList(strings));

        HashMap<String, Set<String>> broadcasts = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");
        broadcasts.put("k1", set1);
        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");
        broadcasts.put("k2", set2);
        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");
        broadcasts.put("k3", set3);
        HashSet<String> set4 = new HashSet<>();
        set4.add("天津");
        set4.add("上海");
        broadcasts.put("k4", set4);
        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");
        broadcasts.put("k5", set5);

        List<String> selects = selectGreedy(cities, broadcasts);
        System.out.println(selects);
    }

    public static List<String> selectGreedy(List<String> cities, HashMap<String, Set<String>> broadcasts) {
        ArrayList<String> selects = new ArrayList<>();

        // 记录最大的重复次数
        int max = 0;
        // 临时存储当前广播能够覆盖的地区
        HashSet<String> tempSet = new HashSet<>();
        // 记录重复个数最多的key
        String maxKey = "";
        while (cities.size() != 0 || max == 0) {
            max = 0;
            for (Map.Entry<String, Set<String>> e : broadcasts.entrySet()) {
                // 当前广播能够覆盖的地区
                Set<String> coveredCities = e.getValue();
                // 临时存储当前广播能够覆盖的地区
                tempSet.clear();
                tempSet.addAll(coveredCities);
                // tempSet 变为 tempSet和cities的交集
                tempSet.retainAll(cities);
                int size = tempSet.size();
                if (size > max) {
                    maxKey = e.getKey();
                    max = size;
                }
            }
            if (max != 0) {
                selects.add(maxKey);
                cities.removeAll(broadcasts.get(maxKey));
            }
        }


        return selects;
    }
}
