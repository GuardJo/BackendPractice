package org.example.was;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class QueryStrings {
    private final List<QueryString> queryStrings;

    public QueryStrings(String queryStringLine) {
        this.queryStrings = new ArrayList<>();

        String[] quertStringList = queryStringLine.split("&");

        Arrays.stream(quertStringList)
                .forEach((queryString) -> {
                    String[] queries = queryString.split("=");
                    if (queries.length != 2) {
                        throw new IllegalArgumentException("Wrong Query Type");
                    }
                    this.queryStrings.add(new QueryString(queries[0], queries[1]));
                });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryStrings that = (QueryStrings) o;
        return Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryStrings);
    }
}
