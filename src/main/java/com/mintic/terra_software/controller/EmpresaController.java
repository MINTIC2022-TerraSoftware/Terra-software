package com.mintic.terra_software.controller;

import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.service.ImpEmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public String crear() {
        return "empresas/form-empresas";
    }

    @PostMapping("/guardar")
    public String guardarEmpresa (@ModelAttribute Empresa empresa, Model model, RedirectAttributes attributes) {
        impEmpresaService.guardar(empresa);
        attributes.addFlashAttribute("msg", "Los datos de la empresa fueron guardados!");
        return "redirect:/enterprises/obtener";
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Empresa>  buscarXid (@PathVariable("id") Long id){
        return new ResponseEntity<>(impEmpresaService.empresaXId(id), HttpStatus.OK);
    }

    @PatchMapping("/modificar/{id}")
    public ResponseEntity<Empresa>  modificar (@PathVariable("id") Long id, @RequestBody Empresa empresa){
        return new ResponseEntity<>(impEmpresaService.modificar(id, empresa), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public String borrarEmpresa (@PathVariable Long id){
        impEmpresaService.eliminar(id);
        return "Empresa con id: "+id+" ha sido eliminada!";
    }
}
