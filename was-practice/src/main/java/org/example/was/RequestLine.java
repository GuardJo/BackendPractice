package org.example.was;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPath;
    private String queryString;

    public RequestLine(String requestLine) {
        String[] requestItems = requestLine.split(" ");
        String[] urlItems = requestItems[1].split("\\?");

        this.method = requestItems[0];
        this.urlPath = urlItems[0];

        if (urlItems.length > 1) {
            this.queryString = urlItems[1];
        }
    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryString = queryString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryString, that.queryString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryString);
    }
}
