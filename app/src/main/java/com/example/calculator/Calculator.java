/*

Created by kotiushka posted November 2

 */

package com.example.calculator;

import java.util.Stack;

public class Calculator {

    public static double decide(String expression) {
        String prepared = Prepare_expression(expression);
        String rpn = ExpressionToRPM(prepared);
        return RPMtoAnswer(rpn);

    }


    private static String Prepare_expression(String expression) {
        StringBuilder preparedExpression = new StringBuilder();
        for (int token = 0; token < expression.length(); token++) {
            char symbol = expression.charAt(token);
            if (symbol == '-') {
                if (token == 0) preparedExpression.append(0);
                else if (expression.charAt(token - 1) == '(') preparedExpression.append(0);
            }

            preparedExpression.append(symbol);
        }

        return preparedExpression.toString();
    }

    private static String ExpressionToRPM(String Expr) {

        StringBuilder current = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;
        char current_symbol;
        for (int i = 0; i < Expr.length(); i++) {
            current_symbol = Expr.charAt(i);
            priority = getP(current_symbol);

            if (priority == 0) current.append(current_symbol);
            if (priority == 1) stack.push(current_symbol);

            if (priority > 1) {
                current.append(' ');
                while (!stack.empty()) {
                    if (getP(stack.peek()) >= priority) current.append(stack.pop());
                    else break;
                }
                stack.push(current_symbol);
            }
            if (priority == -1) {
                current.append(' ');
                while (getP(stack.peek()) != 1) current.append(stack.pop());
                stack.pop();
            }
        }
        while (!stack.empty()) current.append(stack.pop());
        return current.toString();
    }


    private static double RPMtoAnswer(String RPM) {
        Stack<Double> stack = new Stack<>();
        StringBuilder operand;
        for (int i = 0; i < RPM.length(); i++) {
            if (getP(RPM.charAt(i)) == ' ')
                continue;
            if (getP(RPM.charAt(i)) == 0) {
                operand = new StringBuilder();
                while (RPM.charAt(i) != ' ' && getP(RPM.charAt(i)) == 0) {
                    operand.append(RPM.charAt(i++));
                    if (i == RPM.length())
                        break;
                }
                stack.push(Double.parseDouble(operand.toString()));

            }
            if (getP(RPM.charAt(i)) > 1) {
                double a = stack.pop();
                double b = stack.pop();
                if (RPM.charAt(i) == '+') stack.push(b + a);
                if (RPM.charAt(i) == '-') stack.push(b - a);
                if (RPM.charAt(i) == '*') stack.push(b * a);
                if (RPM.charAt(i) == '/') stack.push(b / a);
            }
        }
        return stack.pop();
    }


    private static int getP(char token) {
        if (token == '*' || token == '/') return 3;
        else if (token == '+' || token == '-') return 2;
        else if (token == '(') return 1;
        else if (token == ')') return -1;
        else return 0;
    }

}
