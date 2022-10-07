package org.example.restaurant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class FoodTest {
    @DisplayName("요리 생성 테스트")
    @Test
    public void testCreateFood() {
        assertThatCode(() -> new Food("탕수육", 20000))
                .doesNotThrowAnyException();
    }
}
