package org.example.was;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {
    @DisplayName("QueryString 객체 생성 테스트")
    @Test
    public void testCreate() {
        QueryString queryString = new QueryString("operand1", "1");

        assertThat(queryString).isNotNull();
    }
}
