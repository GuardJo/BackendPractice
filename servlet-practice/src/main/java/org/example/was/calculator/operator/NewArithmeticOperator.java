package org.example.was.calculator.operator;

import org.example.was.calculator.PositiveNumber;

public interface NewArithmeticOperator {
    boolean isCurrectOperator(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
