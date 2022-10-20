package org.example.di;

import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class SimpleBeanFactory {
    private final Set<Class<?>> preClasses;
    private Map<Class<?>, Object> beans = new HashMap<>();

    public SimpleBeanFactory(Set<Class<?>> preClasses) {
        this.preClasses = preClasses;
        initBeans();
    }

    private void initBeans() {
        for (Class<?> clazz : preClasses) {
            Object instance = getInstance(clazz);

            beans.put(clazz, instance);
        }
    }

    private Object getInstance(Class<?> clazz) {
        Constructor<?> constructor = findConstructor(clazz);

        List<Object> params = new ArrayList<>();

        for (Class<?> paramTypeClass : constructor.getParameterTypes()) {
            params.add(getParameterByClass(paramTypeClass));
        }

        try {
            return constructor.newInstance(params.toArray());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Constructor<?> findConstructor(Class<?> clazz) {
        Set<Constructor> injectedConstructors = ReflectionUtils.getAllConstructors(clazz,
                ReflectionUtils.withAnnotation(Inject.class));

        if (injectedConstructors.size() == 0) {
            // Inject 어노테이션이 붙은 생성자를 찾지 못했을 경우 일반 생성자 중 첫번째 반환
            return clazz.getConstructors()[0];
        }

        return injectedConstructors.iterator().next();
    }

    private Object getParameterByClass(Class<?> paramTypeClass) {
        Object paramInstance = getBean(paramTypeClass);

        if (Objects.isNull(paramInstance)) {
            return getInstance(paramTypeClass);
        }

        return paramInstance;
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.get(clazz);
    }
}
