package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empresa;

import java.util.List;

public interface IEmpresaService {

    List<Empresa> buscarTodas();

    Empresa guardar(Empresa empresa);

    Empresa modificar(Long idEmpresa, Empresa empresa);

    void eliminar(Long idEmpresa);

    Empresa empresaXId(Long idEmpresa);
}
