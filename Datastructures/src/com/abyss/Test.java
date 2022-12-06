package com.abyss;

import java.util.Objects;

/**
 * @author Abyss Watchers
 * @create 2022-10-16 15:08
 */
public class Test {
    private String name;
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = t1;
        System.out.println(t1.hashCode() + "  " + t2.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
