package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class    EmpresaService implements ImpEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> buscarTodas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void eliminar(Long idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }

    @Override
    public Empresa modificar(Long idEmpresa, Empresa empresa) {

        Empresa empresaEntity = null;
        Empresa empresaDto = new Empresa();

        Optional<Empresa> empresaOpt = empresaRepository.findById(idEmpresa);

        if (empresaOpt.isPresent()){
            empresaEntity = empresaOpt.get();
            if(empresaEntity.equals(empresa)){
                return null;
            }
            empresaEntity.setNombre(empresa.getNombre());
            empresaEntity.setTelefono(empresa.getTelefono());
            empresaEntity.setDireccion(empresa.getDireccion());
            empresaEntity.setNit(empresa.getNit());
            empresaRepository.save(empresaEntity);
        }
        return empresaEntity;
    }

    @Override
    public Empresa empresaXId(Long idEmpresa) {
        Empresa empresa;
        Optional<Empresa> empresaOpt = empresaRepository.findById(idEmpresa);
        if (empresaOpt.isPresent()){
            empresa = empresaOpt.get();
        }else{
            empresa = null;
        }
        return empresa;
    }
}
