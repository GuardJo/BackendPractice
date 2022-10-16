package org.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RootController {
    String handleMapping(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
}
