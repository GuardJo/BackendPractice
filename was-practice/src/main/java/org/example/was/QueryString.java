package org.example.was;

import java.util.Objects;

public class QueryString {
    private String key;
    private String value;

    public QueryString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean hasValue(String key) {
        return this.key.equals(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryString that = (QueryString) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public String getValue() {
        return this.value;
    }
}
