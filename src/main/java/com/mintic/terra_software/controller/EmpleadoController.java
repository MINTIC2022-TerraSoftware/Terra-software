package com.mintic.terra_software.controller;

import com.mintic.terra_software.model.Empleado;
import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.model.MovimientoDinero;
import com.mintic.terra_software.service.EmpleadoService;
import com.mintic.terra_software.service.ImpEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empleados")
public class EmpleadoController {
    @Autowired
    private ImpEmpleadoService impEmpleadoService;

    @GetMapping ("")
    public ResponseEntity <List<Empleado>>obtenerUsuarios (){

        return new ResponseEntity<>(impEmpleadoService.obtenerEmpleados(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<Empleado>> guardarEmpleado (@RequestBody Empleado empleado){
        impEmpleadoService.guardar(empleado);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Empleado>  modificar (@PathVariable("id") Long id, @RequestBody Empleado empleado){
        return new ResponseEntity<>(impEmpleadoService.modificar(id, empleado), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado>  buscarXid (@PathVariable("id") Long id){
        return new ResponseEntity<>(impEmpleadoService.empeladoxId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String borrarEmpleado(@PathVariable Long id){
        impEmpleadoService.eliminar(id);
        return "El empleado con id: "+id+" ha sido eliminado!!";
    }

}

