package com.mintic.terra_software.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;


@org.springframework.stereotype.Controller

public class HomeController {

    @GetMapping("/home")
    public String home(Model model){

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


    /**
     * Metodo que agrega al modelo datos genéricos para todo el controlador
     * @param model
     */
    @ModelAttribute
    public void setGenericos(Model model){
        model.addAttribute("mensaje", "Bienvenidos tripulantes");
        /*model.addAttribute("", );
        model.addAttribute("", );
        model.addAttribute("", );*/
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


}

