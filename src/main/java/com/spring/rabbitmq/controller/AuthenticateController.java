package com.spring.rabbitmq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class AuthenticateController {

    @RequestMapping(value = "", method = GET)
    public ModelAndView getAuthenticationPage() {
        ModelAndView authentication = new ModelAndView("authentication");
        return authentication;
    }
}
