package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empleado;
import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements ImpEmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerEmpleados() {

        return empleadoRepository.findAll();
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }


    @Override
    public Empleado modificar(Long idEmpleado, Empleado empleado) {

        Empleado empleadoEntity = null;
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(idEmpleado);

        if(empleadoOpt.isPresent()){
            empleadoEntity = empleadoOpt.get();
            if(empleadoEntity.equals(empleado)){
                return null;
            }
            empleadoEntity.setNombreEmpleado(empleado.getNombreEmpleado());
            empleadoEntity.setCorreoEmpleado(empleado.getCorreoEmpleado());
            empleadoEntity.setRolEmpleado((empleado.getRolEmpleado()));
            empleadoRepository.save(empleadoEntity);
        }

        return empleadoEntity;
    }

    @Override
    public Empleado empeladoxId(Long id) {
        Empleado empleado;
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(id);
        if (empleadoOpt.isPresent()){
            empleado = empleadoOpt.get();
        }else{
            empleado = null;
        }
        return empleado;


    }

    @Override
    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }
}
