package org.example.was;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequest {
    private final RequestLine requestLine;

    public HttpRequest(BufferedReader bufferedReader) throws IOException {
        this.requestLine = new RequestLine(bufferedReader.readLine());
    }

    public String getUrlPath() {
        return this.requestLine.getUrlPath();
    }

    public boolean isGetMethod() {
        return this.requestLine.getMethod().equals("GET");
    }

    public RequestLine getRequestLine() {
        return this.requestLine;
    }
}
