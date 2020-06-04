package com.taskManager.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/main")
public class MainController {

    @RequestMapping("/start")
    public ModelAndView startingProject(Model model){
        model.addAttribute("message", "Welcome");
        return new ModelAndView("main");
    }

}
