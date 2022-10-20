package org.example.mvc;

import org.example.mvc.annotation.RequestMethod;

import java.util.Objects;

public class HandlerKey {
    private String contextPath;
    private RequestMethod requestMethod;

    public HandlerKey(String contextPath, RequestMethod requestMethod) {
        this.contextPath = contextPath;
        this.requestMethod = requestMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return Objects.equals(contextPath, that.contextPath) && Objects.equals(requestMethod, that.requestMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contextPath, requestMethod);
    }
}
