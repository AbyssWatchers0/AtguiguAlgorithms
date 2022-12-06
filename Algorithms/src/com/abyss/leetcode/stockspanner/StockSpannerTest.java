package com.abyss.leetcode.stockspanner;

/**
 * @author Abyss Watchers
 * @create 2022-10-21 21:00
 */
public class StockSpannerTest {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] arr = {31, 41, 48, 59, 79}; // 1 2 3 4 5
        for (int i : arr) {
            System.out.println(stockSpanner.next(i));
        }
    }
}

class StockSpanner {
    private int[] prices;
    private int[] days;
    private int index = 0;

    public StockSpanner() {
        prices = new int[10000];
        days = new int[10000];
    }

    public int next(int price) {
        if (index == 0) {
            prices[index] = price;
            days[index] = 1;
        } else {
            int cur = index - 1;
            int day = 1;
            while (prices[cur] <= price) {
                day = day + days[cur];
                if (--cur < 0) {
                    break;
                }
            }
            index = cur + 1;
            prices[index] = price;
            days[index] = day;
        }

        return days[index++];
    }
}