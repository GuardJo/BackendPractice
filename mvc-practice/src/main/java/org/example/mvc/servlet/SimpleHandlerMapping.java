package org.example.mvc.servlet;

import org.example.mvc.HandlerKey;
import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMethod;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleHandlerMapping {
    private Map<HandlerKey, Class<?>> controllers = new HashMap<>();

    public void init() {
        Reflections reflections = new Reflections("org.example.mvc");
        Set<Class<?>> beans = reflections.getTypesAnnotatedWith(Controller.class);

        beans.forEach((bean) -> {
            String contextPath = bean.getAnnotation(Controller.class).contextPath();
            RequestMethod requestMethod = bean.getAnnotation(Controller.class).method();

            controllers.put(new HandlerKey(contextPath, requestMethod), bean);
        });
    }

    public Class<?> findController(HandlerKey handlerKey) {
        return this.controllers.get(handlerKey);
    }
}
