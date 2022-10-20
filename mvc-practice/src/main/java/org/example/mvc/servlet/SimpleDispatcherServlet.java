package org.example.mvc.servlet;

import org.example.mvc.ControllerHandlerAdapter;
import org.example.mvc.HandlerKey;
import org.example.mvc.SimpleHandlerAdapter;
import org.example.mvc.annotation.RequestMethod;
import org.example.mvc.view.ModelAndView;
import org.example.mvc.view.SimpleViewResolver;
import org.example.mvc.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class SimpleDispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(SimpleDispatcherServlet.class);
    private SimpleHandlerMapping requestMappingHandler;
    private List<SimpleHandlerAdapter> simpleHandlerAdapters;

    @Override
    public void init() throws ServletException {
        this.requestMappingHandler = new SimpleHandlerMapping();
        requestMappingHandler.init();
        simpleHandlerAdapters = List.of(new ControllerHandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[Test] DispatcherServlet service started.");

        AnnotationHandler controller = requestMappingHandler.findController(new HandlerKey(req.getServletPath(),
                Enum.valueOf(RequestMethod.class, req.getMethod())));

        if (controller == null) {
            return;
        }

        SimpleHandlerAdapter handlerAdapter = simpleHandlerAdapters.stream()
                .filter(simpleHandlerAdapter -> simpleHandlerAdapter.isSupport(controller))
                .findFirst()
                .orElseThrow(() -> new ServletException("No adapter for handler[" + controller + "]"));

        log.info("find {}", controller.getClassName());

        try {
            ModelAndView modelAndView = handlerAdapter.handleAdapter(req, resp, controller);

            log.info("path : {}", modelAndView.getViewName());

            View view = SimpleViewResolver.resolveview(modelAndView.getViewName());
            view.render(req, resp);

        } catch (Exception e) {
            log.error("Reflections Error, {}", e.getMessage(), e);
        }
    }
}
