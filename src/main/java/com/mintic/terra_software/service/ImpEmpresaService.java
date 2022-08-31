package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empresa;

import java.util.List;

public interface ImpEmpresaService {

    List<Empresa> buscarTodas();

    void guardar(Empresa empresa);

    void eliminar(int idEmpresa);

    Empresa empresaXId(int idEmpresa);
}
