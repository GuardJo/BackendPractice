package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(contextPath = "/form")
public class FormController implements RootController{
    @Override
    public String handleMapping(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return "UserForm.jsp";
    }
}
