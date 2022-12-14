package org.example.mvc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    private final String DEFAULT_ENCODIG = "UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Not Used
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(DEFAULT_ENCODIG);
        response.setCharacterEncoding(DEFAULT_ENCODIG);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Not Used
    }
}
