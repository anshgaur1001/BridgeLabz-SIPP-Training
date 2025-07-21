package com.evaluator;

public class Main {
	public static void main(String[] args) {
        ExpressionEvaluator evaluator = new PostfixEvaluator();
        String expression = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
        double result = evaluator.evaluate(expression);
        System.out.println("Result: " + result);
    }

}
