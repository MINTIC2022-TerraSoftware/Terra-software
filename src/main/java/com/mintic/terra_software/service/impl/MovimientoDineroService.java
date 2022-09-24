package com.mintic.terra_software.service.impl;

import com.mintic.terra_software.model.MovimientoDinero;
import com.mintic.terra_software.repository.MovimientoDineroRepository;
import com.mintic.terra_software.service.IMovimientoDineroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoDineroService implements IMovimientoDineroService {


    private MovimientoDineroRepository movimientoDineroRepository;

    public MovimientoDineroService(MovimientoDineroRepository movimientoDineroRepository) {
        this.movimientoDineroRepository = movimientoDineroRepository;
    }


    @Override
    public List<MovimientoDinero> buscarMovimientos(){
        this.movimientoDineroRepository = movimientoDineroRepository;
        return movimientoDineroRepository.findAll();
    }

    @Override
    public MovimientoDinero guardarMovimietno(MovimientoDinero movimiento){
        return movimientoDineroRepository.save(movimiento);
    }

    @Override
    public MovimientoDinero modificarMovimiento(Long idMovimiento, MovimientoDinero movimiento) {

        if(movimiento.getConcepto()!=null){
            movimientoDineroRepository.findById(idMovimiento).get().setConcepto(movimiento.getConcepto());
        }
        if(Double.valueOf(movimiento.getMonto())!=null){
            movimientoDineroRepository.findById(idMovimiento).get().setMonto(movimiento.getMonto());
        }
        movimientoDineroRepository.save(movimientoDineroRepository.findById(idMovimiento).get());
        return movimientoDineroRepository.findById(idMovimiento).get();
    }

    @Override
    public void eliminarMovimiento(MovimientoDinero movimiento) {
        movimientoDineroRepository.delete(movimiento);
    }

    @Override
    public MovimientoDinero encontrarMovimientoXId(Long idMovimiento) {
        return movimientoDineroRepository.findById(idMovimiento).get();
    }

}
