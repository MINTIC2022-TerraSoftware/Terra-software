package com.mintic.terra_software.controller;

import com.mintic.terra_software.model.Empleado;
import com.mintic.terra_software.service.IEmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/empleados")
@Slf4j
public class EmpleadoController {
    @Autowired
    private IEmpleadoService impEmpleadoService;

    @GetMapping ("/obtener")
    public String obtenerEmpleados (Model model){
        List<Empleado> lista = this.impEmpleadoService.obtenerEmpleados();
        model.addAttribute("empleados", lista);
        return "empleados/lista-empleados";
    }

    @GetMapping("/crear")
    public String crearEmpleado (Model model){
        model.addAttribute("editar", false);
        model.addAttribute("empresa", null);
        return "empleados/form-empleados";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado (@ModelAttribute Empleado empleado, RedirectAttributes attributes){
        impEmpleadoService.guardar(empleado);
        attributes.addFlashAttribute("msg", "Los datos del empleado fueron guardados!");
        return "redirect:/empleados/obtener";
    }

    @GetMapping("/obtener/{id}")
    public String buscarXid (@PathVariable("id") Long id, Model model){
        Empleado empleado = impEmpleadoService.empeladoxId(id);
        model.addAttribute("editar", true);
        model.addAttribute("empleado", empleado);
        return "empleados/form-empleados";
    }

    @RequestMapping(value = "/modificar/{id}",method = RequestMethod.PATCH, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String  modificar (@PathVariable("id") Long id, Empleado empleado, RedirectAttributes attributes){
        impEmpleadoService.modificar(id, empleado);
        attributes.addFlashAttribute("msg", "Los datos del empleado fueron modificados!");
        return "redirect:/empleados/obtener";
    }

    @DeleteMapping("/eliminar/{id}")
    public String borrarEmpleado(@PathVariable Long id, RedirectAttributes attributes){
        impEmpleadoService.eliminar(id);
        attributes.addFlashAttribute("msg", "el empleado fue eliminado!.");
        return "redirect:/empleados/obtener";
    }


}

