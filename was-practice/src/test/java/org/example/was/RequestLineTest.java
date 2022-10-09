package org.example.was;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestLineTest {
    @DisplayName("RequestLine 객체 생성 테스트")
    @Test
    public void testCreate() {
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=1&operator=+&operand2=2 HTTP/1.1");
        assertThat(requestLine).isNotNull();
        assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate", "operand1=1&operator=+&operand2=2"));
    }
}
