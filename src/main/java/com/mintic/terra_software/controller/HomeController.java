package com.mintic.terra_software.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@org.springframework.stereotype.Controller

public class HomeController {

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("mensaje", "Bienvenidos tripulantes");
        return "home";
    }

    /**
     * Metodo que muestra la vista de la pagina de Acerca
     * @return
     */
    @GetMapping("/about")
    public String mostrarAcerca() {
        return "acerca";
    }

    /**
     * Método que muestra el formulario de login personalizado.
     * @return
     */
    @GetMapping("/login")
    public String mostrarLogin() {
        return "formLogin";
    }

    /**
     * Método personalizado para cerrar la sesión del usuario
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        return "redirect:/";
    }


}

