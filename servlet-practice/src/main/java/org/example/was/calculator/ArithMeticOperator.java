package org.example.was.calculator;

import java.util.Arrays;

public enum ArithMeticOperator {
    ADD("+") {
        @Override
        protected int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUB("-") {
        @Override
        protected int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MUL("*") {
        @Override
        protected int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIV("/") {
        @Override
        protected int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithMeticOperator(String operator) {
        this.operator = operator;
    }

    protected abstract int arithmeticCalculate(int operand1, int operand2);

    public static int calculate(int operand1, String operator, int operand2) {
        ArithMeticOperator arithMeticOperator = Arrays.stream(values())
                .filter((v) -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong Operator"));

        return arithMeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
