package com.mintic.terra_software.controller;


import com.mintic.terra_software.model.MovimientoDinero;
import com.mintic.terra_software.service.impl.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller

@Slf4j
public class MovimientoDineroController {
    @Autowired
    private MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService) {
        this.movimientoDineroService = movimientoDineroService;
    }

    //GET todos los movimientos

//    @GetMapping("/obtener")
//    public String buscarTodas (Model model, Pageable page){
//        Page<Empresa> lista = impEmpresaService.buscarTodas(page);
//        model.addAttribute("empresas", lista);
//        return "empresas/lista-empresas";
    @GetMapping("/movimientos")
    public String buscarTodos(Model model)  {
        List<MovimientoDinero> listaMovimientos = this.movimientoDineroService.buscarMovimientos();
        model.addAttribute("movimientos", listaMovimientos);
        return "movimientos/movimientos";
    }
    //PATCH 1 movimiento

    @GetMapping("/movimientos/crear")
    public String crearMovimiento(Model model){
        model.addAttribute("movimiento", new MovimientoDinero());
        return "/movimientos/nuevo-movimiento";
    }
    @GetMapping("/movimientos/{id}/actualizar")
    public String actualizarMovimiento(@PathVariable Long id,  Model model){
        MovimientoDinero movimientoViejo;
        movimientoViejo = movimientoDineroService.encontrarMovimientoXId(id);
        model.addAttribute("movimiento", movimientoViejo);
        return "/movimientos/actualizar-movimiento";
    }

    @PatchMapping("/movimientos/{id}")
    public RedirectView modificarMovimientoDinero(@PathVariable long id, MovimientoDinero movimientoNuevo) {
        movimientoDineroService.modificarMovimiento(id, movimientoNuevo);
        return new RedirectView("/movimientos");
    }
    //POST 1 movimiento
    @PostMapping("/movimientos/crear")
    public RedirectView colocarUnMovimiento(@ModelAttribute MovimientoDinero movimiento, Model model){
        model.addAttribute(movimiento);
        movimientoDineroService.guardarMovimietno(movimiento);
        return new RedirectView("/movimientos");
    }
    //GET 1 movimiento
    @GetMapping("/movimientos/{id}")
    public MovimientoDinero cogerUnaEmpresa(@PathVariable Long id){
        try {
            return movimientoDineroService.encontrarMovimientoXId(id);
        } catch (Exception e){
            return null;
        }
    }
    //DELETE 1 movimiento
    @DeleteMapping("/movimientos/{id}")
    public RedirectView eliminarMovimientoPorId(@PathVariable Long id) {
        MovimientoDinero mov = movimientoDineroService.encontrarMovimientoXId(id);
        movimientoDineroService.eliminarMovimiento(mov);
        return new RedirectView("/movimientos");
    }

}
