package com.mintic.terra_software.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@org.springframework.stereotype.Controller

public class HomeController {

    /*@Autowired
    private PasswordEncoder passwordEncoder;*/

    @GetMapping("/")
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
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return "redirect:/";
    }

    /**
     * Utileria para encriptar texto con el algorito BCrypt
     * @param texto
     * @return
     */
    /*@GetMapping("/bcrypt/{texto}")
    @ResponseBody
    public String encriptar(@PathVariable("texto") String texto) {
        return texto + " Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
    }*/


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

