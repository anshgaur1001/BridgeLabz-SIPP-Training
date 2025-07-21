package com.evaluator;

import java.util.*;

public class PostfixEvaluator implements ExpressionEvaluator {

    private final Map<Character, Integer> precedence = Map.of(
        '+', 1, '-', 1,
        '*', 2, '/', 2,
        '^', 3
    );

    private boolean isOperator(char ch) {
        return precedence.containsKey(ch);
    }

    private String toPostfix(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isWhitespace(ch)) continue;

            if (Character.isDigit(ch)) {
                while (i < infix.length() && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {
                    output.append(infix.charAt(i));
                    i++;
                }
                output.append(' ');
                i--;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    output.append(stack.pop()).append(' ');
                stack.pop(); // Pop '('
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && isOperator(stack.peek())) {
                    char top = stack.peek();
                    if ((precedence.get(ch) <= precedence.get(top) && ch != '^') || 
                        (ch == '^' && precedence.get(ch) < precedence.get(top))) {
                        output.append(stack.pop()).append(' ');
                    } else {
                        break;
                    }
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            output.append(stack.pop()).append(' ');

        return output.toString();
    }

    private double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        Scanner sc = new Scanner(postfix);

        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                stack.push(sc.nextDouble());
            } else {
                char op = sc.next().charAt(0);
                double b = stack.pop();
                double a = stack.pop();
                switch (op) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                    case '^': stack.push(Math.pow(a, b)); break;
                }
            }
        }

        return stack.pop();
    }

    @Override
    public double evaluate(String expression) {
        String postfix = toPostfix(expression);
        return evaluatePostfix(postfix);
    }
}