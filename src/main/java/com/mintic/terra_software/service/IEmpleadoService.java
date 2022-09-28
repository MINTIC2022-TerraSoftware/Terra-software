package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empleado;

import java.util.List;

public interface IEmpleadoService {

    List <Empleado> obtenerEmpleados();

    Empleado guardar(Empleado empleado);

    Empleado modificar(Long id , Empleado empleado);

    Empleado empeladoxId(Long id);

    void eliminar(Long id);

}
