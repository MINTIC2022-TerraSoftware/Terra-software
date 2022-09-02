package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.model.MovimientoDinero;

import java.util.List;

public interface ImpMovimientoDineroService {

    List<MovimientoDinero> buscarMovimientos();

    MovimientoDinero guardarMovimietno(MovimientoDinero movimiento);

    MovimientoDinero modificarMovimiento(Long idMovimiento, MovimientoDinero movimiento);

    void eliminarMovimiento(MovimientoDinero movimiento);

    MovimientoDinero movimientoXId(Long idMovimiento);
}
