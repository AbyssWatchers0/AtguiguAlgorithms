package com.abyss.polandnotation;


import java.util.Stack;

/**
 * @author Abyss Watchers
 * @create 2022-10-17 20:33
 */
public class InfixToSuffix {
    public static String infixToSuffix(String infixExp) {
        String[] items = infixExp.split(" ");
        Stack<String> suffixStack = new Stack<>();
        Stack<String> opStack = new Stack<>();

        for (int i = 0; i<items.length; i++) {
            if (isNum(items[i])) {
                suffixStack.push(items[i]);
            } else if (isOpe(items[i])) {
                if (opStack.isEmpty() || "(".equals(opStack.peek())) {
                    opStack.push(items[i]);
                } else if (getPriority(items[i]) > getPriority( opStack.peek())) {
                    opStack.push(items[i]);
                } else if (")".equals(items[i])) {
                    while (!"(".equals(opStack.peek())) {
                        suffixStack.push(opStack.pop());
                    }
                    opStack.pop();
                } else {
                    suffixStack.push(opStack.pop());
                    i--;
                }
            } else {
                throw new RuntimeException("表达式有误");
            }
        }

        while (!opStack.isEmpty()) {
            suffixStack.push(opStack.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!suffixStack.isEmpty()) {
            stringBuilder.append(suffixStack.pop()).append(" ");
        }

        return stringBuilder.reverse().toString().trim();
    }

    public static boolean isOpe(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "(".equals(s) || ")".equals(s);
    }
    public static boolean isNum(String s) {
        return s.matches("\\d+");
    }
    public static int getPriority(String s) {
        switch (s) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "(":
                return 3;
            case ")":
                return 0;
            default:
                return -1;
        }
    }
}
