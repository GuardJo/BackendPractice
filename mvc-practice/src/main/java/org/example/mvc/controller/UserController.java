package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.annotation.RequestMethod;
import org.example.mvc.model.User;
import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private final UserRepository userRepository = new UserRepository();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String handleMapping(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setAttribute("userList", UserRepository.findAll());
        return "/UserList.jsp";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String handleCreate(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        User user = new User(httpServletRequest.getParameter("userId"), httpServletRequest.getParameter("userName"));

        userRepository.saveUser(user);

        return "redirect:/user";
    }
}
