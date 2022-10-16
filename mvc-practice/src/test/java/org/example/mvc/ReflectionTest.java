package org.example.mvc;

import org.example.mvc.annotation.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionTest {
    @DisplayName("Controller 어노테이션이 붙은 클래스들을 찾는다")
    @Test
    void testSearchController() {
        Set<Class<?>> controllers = scanController(List.of(Controller.class));

        controllers.forEach((controller) -> {
            System.out.println("Controller : " + controller.getName());
        });

        assertThat(2).isEqualTo(controllers.size());
    }

    private Set<Class<?>> scanController(List<Class<? extends Annotation>> annotaionts) {
        Reflections reflections = new Reflections("org.example.mvc");
        Set<Class<?>> controllers = new HashSet<>();

        annotaionts.forEach((annotation) -> {
            controllers.addAll(reflections.getTypesAnnotatedWith(annotation));
        });

        return controllers;
    }
}
