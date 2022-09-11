package com.mintic.terra_software.controller;

import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.service.ImpEmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/enterprises")
@Slf4j
public class EmpresaController {

    @Autowired
    private ImpEmpresaService impEmpresaService;

    @GetMapping("")
    public ResponseEntity<List<Empresa>>  buscarTodas (){
        return new ResponseEntity<>(impEmpresaService.buscarTodas(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<Empresa>> guardarEmpresa (@RequestBody Empresa empresa){
        impEmpresaService.guardar(empresa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa>  buscarXid (@PathVariable("id") Long id){
        return new ResponseEntity<>(impEmpresaService.empresaXId(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Empresa>  modificar (@PathVariable("id") Long id, @RequestBody Empresa empresa){
        return new ResponseEntity<>(impEmpresaService.modificar(id, empresa), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public String borrarEmpresa (@PathVariable Long id){
        impEmpresaService.eliminar(id);
        return "Empresa con id: "+id+" ha sido eliminada!";
    }
}
