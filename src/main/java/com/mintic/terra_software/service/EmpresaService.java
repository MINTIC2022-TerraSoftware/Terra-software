package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empresa;
import com.mintic.terra_software.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService implements ImpEmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> buscarTodas() {
        return empresaRepository.findAll();
    }

    @Override
    public void guardar(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public void eliminar(int idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }

    @Override
    public Empresa empresaXId(int idEmpresa) {
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
