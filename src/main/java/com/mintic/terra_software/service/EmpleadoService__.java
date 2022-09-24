/* package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empleado;
import com.mintic.terra_software.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  EmpleadoService implements ImpEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Page<Empleado> buscarTodas(Pageable page) {
        return empleadoRepository.findAll(page);
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(Long idEmpleado) {
        empleadoRepository.deleteById(idEmpleado);
    }

    @Override
    public Empleado modificar(Long idEmpleado, Empleado empleado) {

        Empleado empleadoEntity = null;

        Optional<Empleado> empleadoOpt = empleadoRepository.findById(idEmpleado);

        if (empleadoOpt.isPresent()){
            empleadoEntity = empleadoOpt.get();
            if(empleadoEntity.equals(empleado)){
                return null;
            }
            empleadoEntity.setNombreEmpleado(empleado.getNombreEmpleado());
            empleadoEntity.setCorreoEmpleado(empleado.getCorreoEmpleado());
            empleadoEntity.setRolEmpleado(empleado.getRolEmpleado());
            empleadoEntity.setIdEmpresa(empleado.getIdEmpresa());
            empleadoRepository.save(empleadoEntity);
        }
        return empleadoEntity;
    }

    @Override
    public Empleado empleadoXId(Long idEmpleado) {
        Empleado empleado;
        Optional<Empleado> empleadoOpt = empleadoRepository.findById(idEmpleado);
        if (empleadoOpt.isPresent()){
            empleado = empleadoOpt.get();
        }else{
            empleado = null;
        }
        return empleado;
    }
}
 */