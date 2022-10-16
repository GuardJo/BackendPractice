package org.example.mvc.servlet;

import org.example.mvc.controller.HomeController;
import org.example.mvc.controller.RootController;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/")
public class SimpleDispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SimpleDispatcherServlet.class);
    private RequestMappingHandler requestMappingHandler;

    @Override
    public void init() throws ServletException {
        this.requestMappingHandler = new RequestMappingHandler();
        requestMappingHandler.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[Test] DispatcherServlet service started.");

        Class<?> controller = requestMappingHandler.findController(req.getServletPath());

        log.info("find {}", controller.getName());

        try {
            Constructor constructor = controller.getConstructor();
            RootController rootController = (RootController) constructor.newInstance();
            Method method = controller.getMethod("handleMapping", HttpServletRequest.class, HttpServletResponse.class);
            String path= (String) method.invoke(rootController, req, resp);

            log.info("path : {}", path);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            log.error("Reflections Error, {}", e.getMessage(), e);
        }
    }
}
