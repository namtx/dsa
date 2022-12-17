package dev.namtx.leetcode.daily;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int secondOperand = Integer.parseInt(stack.pop());
                int firstOperand = Integer.parseInt(stack.pop());
                int r = 0;
                switch (tokens[i].charAt(0)) {
                    case '+':
                        r = firstOperand + secondOperand;
                        break;
                    case '-':
                        r = firstOperand - secondOperand;
                        break;
                    case '*':
                        r = firstOperand * secondOperand;
                        break;
                    case '/':
                        r = firstOperand / secondOperand;
                        break;
                }
                stack.push(String.valueOf(r));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }
}
