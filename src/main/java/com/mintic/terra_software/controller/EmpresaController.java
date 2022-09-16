package com.mintic.terra_software.controller;

import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.service.ImpEmpresaService;
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
@RequestMapping("/enterprises")
@Slf4j
public class EmpresaController {

    @Autowired
    private ImpEmpresaService impEmpresaService;

    @GetMapping("/obtener")
    public String buscarTodas (Model model, Pageable page){
        Page<Empresa> lista = impEmpresaService.buscarTodas(page);
        model.addAttribute("empresas", lista);
        return "empresas/lista-empresas";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("editar", false);
        model.addAttribute("empresa", null);
        return "empresas/form-empresas";
    }

    @PostMapping("/guardar")
    public String guardarEmpresa (@ModelAttribute Empresa empresa, Model model, RedirectAttributes attributes) {
        impEmpresaService.guardar(empresa);
        attributes.addFlashAttribute("msg", "Los datos de la empresa fueron guardados!");
        return "redirect:/enterprises/obtener";
    }

    @GetMapping("/obtener/{id}")
    public String buscarXid (@PathVariable("id") Long id,  Model model){

        Empresa empresa = impEmpresaService.empresaXId(id);
        model.addAttribute("editar", true);
        model.addAttribute("empresa", empresa);
        return "empresas/form-empresas";
    }


    @RequestMapping(value = "/modificar/{id}",method = RequestMethod.PATCH, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String  modificar (@PathVariable("id") Long id, Empresa empresa, RedirectAttributes attributes){
        impEmpresaService.modificar(id, empresa);
        attributes.addFlashAttribute("msg", "Los datos de la empresa fueron modificados!");
        return "redirect:/enterprises/obtener";
    }

    @DeleteMapping("/eliminar/{id}")
    public String borrarEmpresa (@PathVariable Long id, RedirectAttributes attributes){
        impEmpresaService.eliminar(id);
        attributes.addFlashAttribute("msg", "La empresa fue eliminada!.");
        return "redirect:/enterprises/obtener";
    }
}
