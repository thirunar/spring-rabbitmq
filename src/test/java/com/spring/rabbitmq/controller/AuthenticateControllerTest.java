package com.spring.rabbitmq.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;


public class AuthenticateControllerTest {

    @Autowired
    private AuthenticateController authenticateController;

    @Before
    public void setUp() throws Exception {
        authenticateController = new AuthenticateController();
    }

    @Test
    public void getAuthenticationPageShouldReturnAModelAndView() throws Exception {
        ModelAndView authenticationPage = authenticateController.getAuthenticationPage();

        Assert.assertThat(authenticationPage.getViewName(), is("authentication"));
    }
}