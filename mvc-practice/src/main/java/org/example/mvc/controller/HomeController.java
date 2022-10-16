package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController implements RootController {
    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleMapping(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return "index.html";
    }
}
