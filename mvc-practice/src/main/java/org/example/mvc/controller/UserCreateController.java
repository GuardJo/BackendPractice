package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMethod;
import org.example.mvc.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller(contextPath = "/user", method = RequestMethod.POST)
public class UserCreateController implements RootController{
    @Override
    public String handleMapping(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        User user = new User("userId", "newUser");

        return "redirect:/user";
    }
}
