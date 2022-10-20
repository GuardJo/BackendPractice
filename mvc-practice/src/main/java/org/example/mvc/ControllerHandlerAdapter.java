package org.example.mvc;

import org.example.mvc.servlet.AnnotationHandler;
import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerHandlerAdapter implements SimpleHandlerAdapter{
    @Override
    public boolean isSupport(Object handler) {
        return handler instanceof AnnotationHandler;
    }

    @Override
    public ModelAndView handleAdapter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String viewName = ((AnnotationHandler) handler).handle(httpServletRequest, httpServletResponse);

        ModelAndView modelAndView = new ModelAndView(viewName);

        return modelAndView;
    }
}
