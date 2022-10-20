package org.example.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectView implements View{
    private final String viewName;

    public RedirectView(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String viewSuffix = viewName.substring(SimpleViewResolver.DEFAULT_REDIRECT_PREFIX.length());

        httpServletResponse.sendRedirect(viewSuffix);
    }
}
