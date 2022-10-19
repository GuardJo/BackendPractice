package org.example.mvc.servlet;

import org.example.mvc.HandlerKey;
import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleHandlerMapping {
    private Map<HandlerKey, AnnotationHandler> controllers = new HashMap<>();

    public void init() {
        Reflections reflections = new Reflections("org.example.mvc");
        Set<Class<?>> beans = reflections.getTypesAnnotatedWith(Controller.class);

        beans.forEach((bean) -> {
            Arrays.stream(bean.getDeclaredMethods())
                    .forEach(method -> {
                        RequestMapping requestMapping = method.getDeclaredAnnotation(RequestMapping.class);

                        Arrays.stream(requestMapping.method())
                                .forEach(requestMethod -> controllers.put(
                                        new HandlerKey(requestMapping.value(), requestMethod), new AnnotationHandler(bean, method)
                                ));
                    });
        });
    }

    public AnnotationHandler findController(HandlerKey handlerKey) {
        return this.controllers.get(handlerKey);
    }
}
