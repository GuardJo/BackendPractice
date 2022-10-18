package org.example.mvc.annotation;

import org.example.mvc.controller.RootController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
    String contextPath() default "/";
    RequestMethod method() default RequestMethod.GET;
}
