package com.mintic.terra_software.controller;

import com.mintic.terra_software.model.MovimientoDinero;
import com.mintic.terra_software.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
@Slf4j
public class MovimientoDineroController {
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService) {
        this.movimientoDineroService = movimientoDineroService;
    }

    //GET todos los movimientos

    @GetMapping("/obtener")
    public List<MovimientoDinero> buscarTodos() {
        return this.movimientoDineroService.buscarMovimientos();
    }
    //PATCH 1 movimiento
    @PatchMapping("/{id}")
    public MovimientoDinero modificarMovimientoDinero(@PathVariable long id, @RequestBody MovimientoDinero movimientoNuevo) {
        try{
            return movimientoDineroService.modificarMovimiento(id, movimientoNuevo);
        }catch (Exception e){
            return null;
        }
    }
    //POST 1 movimiento
    @PostMapping("/crear")
    public MovimientoDinero colocarUnMovimiento(@RequestBody MovimientoDinero movimiento){
        return movimientoDineroService.guardarMovimietno(movimiento);
    }
    //GET 1 movimiento
    @GetMapping("/obtener/{id}")
    public MovimientoDinero cogerUnaEmpresa(@PathVariable Long id){
        try {
            return movimientoDineroService.movimientoXId(id);
        } catch (Exception e){
            return null;
        }
    }
    //DELETE 1 movimiento
    @DeleteMapping("/{id}")
    public String eliminarMovimientoPorId(MovimientoDinero mov){
        movimientoDineroService.eliminarMovimiento(mov);
        return "El movimiento de dinero ha sido elimnado";
    }

}
