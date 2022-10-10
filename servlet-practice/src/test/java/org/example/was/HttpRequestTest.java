package org.example.was;

import org.example.was.HttpRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpRequestTest {
    @DisplayName("Http 요청 보낸 데이터 객체 생성")
    @Test
    public void testCreate() throws IOException {
        BufferedReader bufferedReader = new TestBufferedReader(new InputStreamReader(System.in));
        HttpRequest httpRequest = new HttpRequest(bufferedReader);

        assertThat(httpRequest).isNotNull();
    }

    static class TestBufferedReader extends BufferedReader {
        public TestBufferedReader(Reader in) {
            super(in);
        }

        @Override
        public String readLine() throws IOException {
            return "GET /caluate?operand1=1&operator=+&operand2=2 HTTP/1.1";
        }
    }
}
