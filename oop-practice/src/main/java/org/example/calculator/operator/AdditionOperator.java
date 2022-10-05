package org.example.calculator.operator;

public class AdditionOperator implements NewArithmeticOperator {
    @Override
    public boolean isCurrectOperator(String operator) {
        return operator.equals("+");
    }

    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 + operand2;
    }
}
