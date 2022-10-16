package org.example.mvc.servlet;

import org.example.mvc.annotation.Controller;
import org.example.mvc.controller.RootController;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RequestMappingHandler {
    private Map<String, Class<?>> controllers = new HashMap<>();

    public void init() {
        Reflections reflections = new Reflections("org.example.mvc");
        Set<Class<?>> beans = reflections.getTypesAnnotatedWith(Controller.class);

        beans.forEach((bean) -> {
            String contextPath = bean.getAnnotation(Controller.class).contextPath();
            controllers.put(contextPath, bean);
        });
    }

    public Class<?> findController(String contextPath) {
        return this.controllers.get(contextPath);
    }
}
