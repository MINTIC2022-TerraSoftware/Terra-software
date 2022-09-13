package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImpEmpresaService {

    Page<Empresa> buscarTodas(Pageable page);

    Empresa guardar(Empresa empresa);

    Empresa modificar(Long idEmpresa, Empresa empresa);

    void eliminar(Long idEmpresa);

    Empresa empresaXId(Long idEmpresa);
}
