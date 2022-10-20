package org.example.di;

import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.example.controller.UserController;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class SimpleBeanFactoryTest {
    private SimpleBeanFactory simpleBeanFactory;
    private Reflections reflections;

    @BeforeEach
    void setUp() {
        this.reflections = new Reflections("org.example");
        Set<Class<?>> preClasses = getClassesWithAnnotation(Controller.class, Service.class);

        this.simpleBeanFactory = new SimpleBeanFactory(preClasses);
    }

    @DisplayName("DI(@Inject)에 의한 자동 의존 추가 테스트")
    @Test
    void testDpendencyInject() {
        UserController userController = simpleBeanFactory.getBean(UserController.class);

        assertThat(userController).isNotNull();
        assertThatCode(() -> userController.getUserService()).doesNotThrowAnyException();
    }

    private Set<Class<?>> getClassesWithAnnotation(Class<? extends Annotation>... classes) {
        Set<Class<?>> beans = new HashSet<>();

        for (Class<? extends Annotation> annotation : classes) {
            beans.addAll(reflections.getTypesAnnotatedWith(annotation));
        }

        return beans;
    }
}