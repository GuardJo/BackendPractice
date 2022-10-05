package org.example.password.generator.calculator;

public class Calculator {
    public static int calculate(int operand1, String operator, int operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        }
        else if (operator.equals("-")) {
            return operand1 - operand2;
        }
        else if (operator.equals("*")) {
            return operand1 * operand2;
        }
        else if (operator.equals("/")) {
            return operand1 / operand2;
        }
        return operand1 + operand2;
    }
}
