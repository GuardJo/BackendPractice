package org.example.calculator.operator;

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean isCurrectOperator(String operator) {
        return operator.equals("/");
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new IllegalArgumentException("operand is zero");
        }
        return operand1 / operand2;
    }
}
