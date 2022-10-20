package org.example.di;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleBeanFactory {
    private final Set<Class<?>> preClasses;
    private Map<Class<?>, Object> beans = new HashMap<>();

    public SimpleBeanFactory(Set<Class<?>> preClasses) {
        this.preClasses = preClasses;
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.get(clazz);
    }
}
