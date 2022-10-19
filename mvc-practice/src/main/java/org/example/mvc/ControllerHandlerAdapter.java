package org.example.mvc;

import org.example.mvc.controller.RootController;
import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerHandlerAdapter implements SimpleHandlerAdapter{
    @Override
    public boolean isSupport(Object handler) {
        if (handler instanceof Class) {
            try {
                return ((Class) handler).getConstructor().newInstance() instanceof RootController;
            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }

    @Override
    public ModelAndView handleAdapter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String viewName = ((RootController) handler).handleMapping(httpServletRequest, httpServletResponse);

        ModelAndView modelAndView = new ModelAndView(viewName);

        return modelAndView;
    }
}
