package org.example.was.calculator;

import org.example.was.calculator.operator.*;

import java.util.List;

public class Calculator {
    private final static List<NewArithmeticOperator> arithmeticOperators = List.of(
            new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator()
    );

    public static int calculate(int operand1, String operator, int operand2) {
        return arithmeticOperators.stream()
                .filter((arithmeticOperator) -> arithmeticOperator.isCurrectOperator(operator))
                .map((arithmeticOperator) -> arithmeticOperator.calculate(new PositiveNumber(operand1), new PositiveNumber(operand2)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong Operator"));
    }
}
