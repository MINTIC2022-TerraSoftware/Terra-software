package com.mintic.terra_software.service.impl;

import com.mintic.terra_software.model.Empleado;
import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.model.Perfil;
import com.mintic.terra_software.repository.EmpleadoRepository;
import com.mintic.terra_software.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Empleado> obtenerEmpleados() {

        return empleadoRepository.findAll();
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        String pwdPlano = empleado.getPassword();
        // Encriptar el pwd BCryptPasswordEncoder
        String pwdEncriptado = passwordEncoder.encode(pwdPlano);
        empleado.setPassword(pwdEncriptado);
        empleado.setEstatus(1); // Activado por defecto
        empleado.setFechaRegistro(new Date());

        Empresa empresa = new Empresa();
        Long emp = empleado.getIdEmpresa().getId();
        empresa.setId(emp);
        empleado.setIdEmpresa(empresa);
        Perfil perfil = new Perfil();
        perfil.setId(3); // Perfil USUARIO
        empleado.agregarPerfil(perfil);
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
