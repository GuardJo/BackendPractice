package org.example.mvc;

import org.example.mvc.annotation.Controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionTest {
    @DisplayName("Controller 어노테이션이 붙은 클래스들을 찾는다")
    @Test
    void testSearchController() {
        Reflections reflections = new Reflections("org.example.mvc");
        Set<Class<?>> controllers = new HashSet<>();

        controllers.addAll(reflections.getTypesAnnotatedWith(Controller.class));

        controllers.forEach((controller) -> {
            System.out.println("Controller : " + controller.getName());
        });

        assertThat(2).isEqualTo(controllers.size());
    }
}
