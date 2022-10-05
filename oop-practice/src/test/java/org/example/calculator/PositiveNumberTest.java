package org.example.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PositiveNumberTest {
    @DisplayName("피연산자가 양수 일 때 정상 값 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void testIsPositiveNumber(int value) {
        assertThat(new PositiveNumber(value).getNumber()).isEqualTo(value);
    }

    @DisplayName("피연산자가 0 이하일 떄 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -100})
    void testIsNegativeNumber(int value) {
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
