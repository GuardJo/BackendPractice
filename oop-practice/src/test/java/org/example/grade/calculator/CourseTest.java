package org.example.grade.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {
    @DisplayName("과목 생성 테스트")
    @Test
    public void testCreate() {
        assertThatCode(() -> new Course("객체지향프로그래밍", 3, "B"))
                .doesNotThrowAnyException();
    }
}
