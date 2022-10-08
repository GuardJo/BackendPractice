package org.example.was.calculator.operator;

import org.example.was.calculator.PositiveNumber;

public class SubtractionOperator implements NewArithmeticOperator {
    @Override
    public boolean isCurrectOperator(String operator) {
        return operator.equals("-");
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.getNumber() - operand2.getNumber();
    }
}
