package org.example.restaurant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuItemTest {
    @DisplayName("메뉴 생성 테스트")
    @Test
    public void testCreateMenuItem() {
        assertThatCode(() -> new MenuItem("탕수육", 20000))
                .doesNotThrowAnyException();
    }
}
