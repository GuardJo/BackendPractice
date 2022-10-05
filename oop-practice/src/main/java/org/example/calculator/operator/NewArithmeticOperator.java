package org.example.calculator.operator;

import org.example.calculator.PositiveNumber;

public interface NewArithmeticOperator {
    boolean isCurrectOperator(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
