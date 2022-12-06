package com.abyss.polandnotation;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Abyss Watchers
 * @create 2022-10-17 20:54
 */
public class PolandCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String suffix = InfixToSuffix.infixToSuffix(s);

        int res = calculate(suffix);
        System.out.println(res);

    }

    public static int calculate(String suffix) {
        String[] strings = suffix.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String s : strings) {
            if (s.matches("\\d+")) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
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

        return stack.pop();
    }
}
