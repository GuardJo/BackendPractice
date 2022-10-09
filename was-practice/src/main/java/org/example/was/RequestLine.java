package org.example.was;

import java.util.Objects;

public class RequestLine {
    private final String method;
    private final String urlPath;
    private QueryStrings queryStrings;

    public RequestLine(String requestLine) {
        String[] requestItems = requestLine.split(" ");
        String[] urlItems = requestItems[1].split("\\?");

        this.method = requestItems[0];
        this.urlPath = urlItems[0];

        if (urlItems.length > 1) {
            this.queryStrings = new QueryStrings(urlItems[1]);
        }
    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    public String getUrlPath() {
        return this.urlPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }

    public String getMethod() {
        return this.method;
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }
}
