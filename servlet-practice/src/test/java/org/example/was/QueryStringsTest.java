package org.example.was;

import org.example.was.QueryStrings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @DisplayName("QueryString 관련 1급 컬렉션 생성 테스트")
    @Test
    public void testCreate() {
        QueryStrings queryStrings = new QueryStrings("operand1=1&operator=+&operand2=2");

        assertThat(queryStrings).isNotNull();
    }
}
