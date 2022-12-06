package com.abyss.hashtable;

/**
 * @author Abyss Watchers
 * @create 2022-10-30 18:46
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashMap<Emp, String> map = new HashMap<>();
        map.push(new Emp(0, "jfz"), "jfznb");
        map.push(new Emp(1, "jfz"), "jfznbb");
        map.show();

        System.out.println(map.get(new Emp(0, "jfz")));
    }
}
