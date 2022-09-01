package com.mintic.terra_software.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller

public class HomeController {

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("mensaje", "Bienvenidos tripulantes");
        return "home";
    }

}

