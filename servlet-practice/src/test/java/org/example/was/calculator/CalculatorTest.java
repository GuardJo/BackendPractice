package org.example.was.calculator;

import org.example.was.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 사칙 연산 계산기 테스트
 * 양수만 계산가능
 * 나눗셈에서 0으로 나뉘는 경우 IllegalArgumentException 발생
 * MVC 패턴 기반으로 구현
 */
public class CalculatorTest {
    @DisplayName("덧셈 연산 정상 수행")
    @Test
    void testAdd() {
        int result = Calculator.calculate(1, "+", 2);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺼셈 연산 정상 수행")
    @Test
    void testSub() {
        int result = Calculator.calculate(1, "-", 2);

        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("사칙 연산 정상 수행")
    @ParameterizedTest
    @MethodSource("getCalcTestParams")
    void testCalculate(int operand1, String operator, int operand2, int result) {
        int testResult = Calculator.calculate(operand1, operator, operand2);

        assertThat(testResult).isEqualTo(result);
    }

    private static Stream<Arguments> getCalcTestParams() {
        Stream<Arguments> args = Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(2, "*", 2, 4),
                arguments(4, "/", 2, 2)
        );

        return args;
    }
}
