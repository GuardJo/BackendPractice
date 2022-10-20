package org.example.mvc.view;

public class SimpleViewResolver {
    public final static String DEFAULT_REDIRECT_PREFIX = "redirect:";

    public static View resolveview(String viewName) {
        if (viewName.contains(DEFAULT_REDIRECT_PREFIX)) {
            return new RedirectView(viewName);
        }
        else {
            return new JspView(viewName);
        }
    }
}
