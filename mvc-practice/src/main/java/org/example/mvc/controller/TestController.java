package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.annotation.RequestMethod;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class TestController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(HttpRequest request, HttpResponse response) {
        return "test";
    }
}
