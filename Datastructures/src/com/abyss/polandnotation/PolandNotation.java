package com.abyss.polandnotation;


import java.util.Stack;

/**
 * @author Abyss Watchers
 * @create 2022-10-16 22:03
 */
public class PolandNotation {
    public static void main(String[] args) {
        String polandExp = "4 5 * 8 - 60 + 8 2 / +"; // 76

        String[] strings = polandExp.split(" ");
        Stack stack = new Stack();

        for (String s :
                strings) {
            if (s.matches("\\d+")) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer num2 = (Integer) stack.pop();
                Integer num1 = (Integer) stack.pop();
                Integer res = 0;
                if ("+".equals(s)) {
                    res = num1 + num2;
                } else if ("-".equals(s)) {
                    res = num1 - num2;
                } else if ("*".equals(s)) {
                    res = num1 * num2;
                } else if ("/".equals(s)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("符号有误");
                }
                stack.push(res);
            }
        }

        System.out.println(stack.pop());
    }

}
