package org.example.restaurant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChiefTest {
    @DisplayName("주어진 메뉴에 따른 요리 생성 테스트")
    @Test
    public void testCook() {
        MenuItem menuItem = new MenuItem("탕수육", 20000);
        Food food = new Food("탕수육", 20000);
        Chief chief = new Chief();
        Food resultFood = chief.cook(menuItem);

        assertThat(resultFood).isEqualTo(food);
    }
}
