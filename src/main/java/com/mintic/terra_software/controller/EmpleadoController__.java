/* package com.mintic.terra_software.controller;

import com.mintic.terra_software.model.Empleado;
import com.mintic.terra_software.service.ImpEmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private ImpEmpleadoService impEmpleadoService;

    @GetMapping("/obtener")
    public String buscarTodas (Model model, Pageable page){
        Page<Empleado> lista = impEmpleadoService.buscarTodas(page);
        model.addAttribute("empleados", lista);
        return "empleados/lista-empleados";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("editar", false);
        model.addAttribute("empleado", null);
        return "empleados/form-empleados";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado (@ModelAttribute Empleado empleado, Model model, RedirectAttributes attributes) {
        impEmpleadoService.guardar(empleado);
        attributes.addFlashAttribute("msg", "Los datos del empleado fueron guardados!");
        return "redirect:/empleados/obtener";
    }

    @GetMapping("/obtener/{id}")
    public String buscarXid (@PathVariable("id") Long id,  Model model){

        Empleado empleado = impEmpleadoService.empleadoXId(id);
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
    public String borrarEmpleado (@PathVariable Long id, RedirectAttributes attributes){
        impEmpleadoService.eliminar(id);
        attributes.addFlashAttribute("msg", "El empleado fue eliminado!.");
        return "redirect:/empleados/obtener";
    }
}
 */