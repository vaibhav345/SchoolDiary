package org.application.schooldiary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControllerClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerClass.class);

    @RequestMapping(value = "/")
    public ModelAndView home() { return new ModelAndView("home"); }

    @RequestMapping(value = "/register.html")
    public ModelAndView register() {
        return new ModelAndView("register");
    }
}
