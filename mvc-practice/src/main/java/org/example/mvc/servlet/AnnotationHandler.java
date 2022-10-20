package org.example.mvc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationHandler {
    private final Class clazz;
    private final Method method;

    public AnnotationHandler(Class clazz, Method method) {
        this.clazz = clazz;
        this.method = method;
    }

    public String handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getConstructor();
        return (String) this.method.invoke(constructor.newInstance(), httpServletRequest, httpServletResponse);
    }

    public String getClassName() {
        return this.clazz.getName();
    }
}
