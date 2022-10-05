package org.example.calculator.operator;

public interface NewArithmeticOperator {
    boolean isCurrectOperator(String operator);
    int calculate(int operand1, int operand2);
}
