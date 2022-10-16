package org.example.mvc;

import org.example.mvc.annotation.Controller;
import org.example.mvc.model.User;
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

    @DisplayName("Heap 영역에서 클래스 객체를 가져오는 세 가지 방법")
    @Test
    void testLoad() throws ClassNotFoundException {
        // 첫번째 방법
        Class<User> user1 = User.class;

        // 두번째 방법
        User user = new User("id", "name");
        Class<User> user2 = (Class<User>) user.getClass();

        // 세번째 방법
        Class<User> user3 = (Class<User>) Class.forName("org.example.mvc.model.User");

        assertThat(user1).isEqualTo(user2);
        assertThat(user2).isEqualTo(user3);
        assertThat(user3).isEqualTo(user1);
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
