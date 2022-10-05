package org.example.password.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 비밀번호는 8자 이상, 12자 이하
 * 비밀번호는 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생
 * 경계 조건에 대해 테스트 코드 작성
 */
public class PasswordValidatorTest {
    @DisplayName("비밃 번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다")
    @Test
    void vaidatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("passwordtest"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 혹은 12자 초과하는 경우 IllegalArgumentException 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"abcdefg", "abcdefghijklm"})
    void validatePasswordTest2(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 8자 이상이어야 한다");
    }
}
