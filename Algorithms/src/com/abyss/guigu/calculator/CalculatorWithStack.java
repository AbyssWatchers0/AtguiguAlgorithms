package com.abyss.guigu.calculator;

import java.util.Stack;

/**
 * @author Abyss Watchers
 * @create 2022-10-15 20:58
 */
public class CalculatorWithStack {
    public static void main(String[] args) {
        String exp = "1-2+3";
        int res = calculate(exp);
        System.out.println(res);
    }

    public static int calculate(String exp) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();

        char[] chars = exp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isDigit(chars[i])) {
                int num = Integer.parseInt(String.valueOf(chars[i]));
                // 如果是数字，看它后面是不是数字，以达到运算多位数的效果
                while (i<chars.length-1 && isDigit(chars[i+1])) {
                    num = num * 10 + Integer.parseInt(String.valueOf(chars[i+1]));
                    i++;
                }
                numStack.push(num);
            } else if (isOperator(chars[i])) {
                if (opStack.isEmpty()) {
                    opStack.push(String.valueOf(chars[i]));
                } else {
                    // 判断运算符优先级
                    if (getPriority(chars[i]) <= getPriority(opStack.peek().charAt(0))) {
                        // 小于等于 取前两个数字 和 一个操作符 运算后 将结果入栈 新运算符入栈
                        int suf = numStack.pop();
                        int pre = numStack.pop();
                        String  op = opStack.pop();
                        int res = calculate(pre, suf, op);

                        numStack.push(res);
                        opStack.push(String.valueOf(chars[i]));
                    } else {
                        // 大于 直接入运算符栈
                        opStack.push(String.valueOf(chars[i]));
                    }
                }
            } else {
                throw new RuntimeException(chars[i] + " is not supported!");
            }
        }

        while (!opStack.isEmpty()) {
            int suf = numStack.pop();
            int pre = numStack.pop();
            String  op = opStack.pop();
            int res = calculate(pre, suf, op);

            numStack.push(res);
        }

        return numStack.pop();
    }

    public static int getPriority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            default:
                return -1;
        }
    }

    public static int calculate(int pre, int suf, String op) {
        switch (op) {
            case "+":
                return pre + suf;
            case "-":
                return pre - suf;
            case "*":
                return pre * suf;
            case "/":
                return pre / suf;
            default:
                return 0;
        }
    }

    public static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
